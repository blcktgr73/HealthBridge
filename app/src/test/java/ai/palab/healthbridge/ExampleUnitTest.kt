package ai.palab.healthbridge

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
    fun summary_supportsAnEmptyDayList() {
        val summary = SyntheticStepSummary.calculate(emptyList())

        assertEquals(0, summary.totalSteps)
        assertEquals(0.0, summary.averageSteps, 0.0)
    }
}
