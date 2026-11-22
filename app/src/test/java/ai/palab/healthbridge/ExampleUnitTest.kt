package ai.palab.healthbridge

import java.util.Calendar
import java.util.TimeZone
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun syntheticSevenDaySummary_calculatesTotalAndAverage() {
        val summary = SyntheticStepSummary.calculate()

        assertEquals(7, summary.days.size)
        assertEquals(53_070, summary.totalSteps)
        assertEquals(7_581.428571, summary.averageSteps, 0.000001)
    }

    @Test
    fun syntheticDates_coverSevenDaysAcrossYearBoundary() {
        val today = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul")).apply {
            set(2027, Calendar.JANUARY, 2, 12, 0, 0)
        }

        val days = SyntheticStepSummary.recentSevenDays(today)

        assertEquals(listOf("12월 27일", "12월 28일", "12월 29일", "12월 30일", "12월 31일", "1월 1일", "1월 2일"), days.map { it.dateLabel })
        assertEquals(2, today.get(Calendar.DAY_OF_MONTH))
    }

    @Test
    fun summary_supportsAnEmptyDayList() {
        val summary = SyntheticStepSummary.calculate(emptyList())

        assertEquals(0, summary.totalSteps)
        assertEquals(0.0, summary.averageSteps, 0.0)
    }

    @Test
    fun syntheticSteps_areNormalizedToHealthV1WithoutInventingUnavailableValues() {
        val payload = HealthV1PayloadFactory.fromSyntheticSteps(
            summary = SyntheticStepSummary.calculate(),
            periodStart = "2026-11-15T00:00:00+09:00",
            periodEnd = "2026-11-22T00:00:00+09:00",
            timezone = "Asia/Seoul",
            collectedAt = "2026-11-22T00:00:00+09:00",
        )

        assertEquals("health.v1", payload.schemaVersion)
        assertEquals("synthetic-healthbridge-fixture", payload.deviceId)
        assertTrue(payload.isSyntheticFixture)
        assertEquals("2026-11-15T00:00:00+09:00", payload.period.start)
        assertEquals("2026-11-22T00:00:00+09:00", payload.period.end)
        assertEquals("Asia/Seoul", payload.period.timezone)
        assertEquals(53_070, payload.dailySummary.steps)
        assertNull(payload.dailySummary.distanceM)
        assertNull(payload.dailySummary.activeCaloriesKcal)
        assertNull(payload.dailySummary.sleepMinutes)
        assertTrue(payload.exerciseSessions.isEmpty())
        assertTrue(payload.sleepSessions.isEmpty())
    }

    @Test
    fun period_rejectsAnEndBeforeOrEqualToStart() {
        assertThrows(IllegalArgumentException::class.java) {
            HealthPeriod(
                start = "2026-11-22T00:00:00+09:00",
                end = "2026-11-22T00:00:00+09:00",
                timezone = "Asia/Seoul",
            )
        }
        assertThrows(IllegalArgumentException::class.java) {
            HealthPeriod(
                start = "2026-11-23T00:00:00+09:00",
                end = "2026-11-22T00:00:00+09:00",
                timezone = "Asia/Seoul",
            )
        }
    }

    @Test
    fun period_rejectsMalformedOffsetsAndCalendarValues() {
        val invalidPeriods = listOf(
            "2026-11-22T00:00:00+24:00",
            "2026-11-22T00:00:00-24:00",
            "2026-11-22T00:00:00+09:60",
            "2026-02-30T00:00:00Z",
        )

        invalidPeriods.forEach { invalidPeriod ->
            assertThrows(IllegalArgumentException::class.java) {
                HealthPeriod(
                    start = invalidPeriod,
                    end = "2026-11-23T00:00:00Z",
                    timezone = "UTC",
                )
            }
        }
    }

    @Test
    fun period_acceptsValidOffsetBoundariesAndPreservesAbsoluteOrdering() {
        val period = HealthPeriod(
            start = "2026-11-22T00:00:00Z",
            end = "2026-11-22T23:59:59-23:59",
            timezone = "UTC",
        )

        assertEquals("2026-11-22T00:00:00Z", period.start)
        assertEquals("2026-11-22T23:59:59-23:59", period.end)
    }
}
