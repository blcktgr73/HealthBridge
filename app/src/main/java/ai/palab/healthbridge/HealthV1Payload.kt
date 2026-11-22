package ai.palab.healthbridge

import java.util.Calendar
import java.util.GregorianCalendar
import java.util.TimeZone

data class HealthPeriod(
    val start: String,
    val end: String,
    val timezone: String,
) {
    init {
        require(timezone.isNotBlank()) { "timezone must not be blank" }
        require(parseIsoOffsetMillis(start) < parseIsoOffsetMillis(end)) {
            "period start must be before period end"
        }
    }
}

data class DailyHealthSummary(
    val steps: Int,
    val distanceM: Int? = null,
    val activeCaloriesKcal: Int? = null,
    val sleepMinutes: Int? = null,
)

data class ExerciseSession(
    val start: String,
    val end: String,
)

data class SleepSession(
    val start: String,
    val end: String,
)

data class SyncMetadata(
    val collectedAt: String,
    val cursor: String? = null,
    val deletedRecordIds: List<String> = emptyList(),
)

data class HealthV1Payload(
    val schemaVersion: String,
    val deviceId: String,
    val period: HealthPeriod,
    val dailySummary: DailyHealthSummary,
    val exerciseSessions: List<ExerciseSession>,
    val sleepSessions: List<SleepSession>,
    val sync: SyncMetadata,
    val isSyntheticFixture: Boolean,
)

object HealthV1PayloadFactory {
    const val SCHEMA_VERSION = "health.v1"
    const val SYNTHETIC_DEVICE_ID = "synthetic-healthbridge-fixture"

    fun fromSyntheticSteps(
        summary: StepSummary,
        periodStart: String,
        periodEnd: String,
        timezone: String,
        collectedAt: String,
    ): HealthV1Payload {
        val period = HealthPeriod(periodStart, periodEnd, timezone)
        require(collectedAt.isNotBlank()) { "collectedAt must not be blank" }

        return HealthV1Payload(
            schemaVersion = SCHEMA_VERSION,
            deviceId = SYNTHETIC_DEVICE_ID,
            period = period,
            dailySummary = DailyHealthSummary(steps = summary.totalSteps),
            exerciseSessions = emptyList(),
            sleepSessions = emptyList(),
            sync = SyncMetadata(collectedAt = collectedAt),
            isSyntheticFixture = true,
        )
    }
}

private fun parseIsoOffsetMillis(value: String): Long {
    val match = ISO_OFFSET_PATTERN.matchEntire(value)
        ?: throw IllegalArgumentException("timestamp must be ISO-8601 with an offset: $value")
    val parts = match.groupValues
    if (parts[7] != "Z") {
        val offsetHours = parts[9].toInt()
        val offsetMinutes = parts[10].toInt()
        require(offsetHours in 0..23) {
            "timestamp offset hour must be between 00 and 23: $value"
        }
        require(offsetMinutes in 0..59) {
            "timestamp offset minute must be between 00 and 59: $value"
        }
    }
    val calendar = GregorianCalendar(TimeZone.getTimeZone("UTC")).apply {
        isLenient = false
        clear()
        set(Calendar.YEAR, parts[1].toInt())
        set(Calendar.MONTH, parts[2].toInt() - 1)
        set(Calendar.DAY_OF_MONTH, parts[3].toInt())
        set(Calendar.HOUR_OF_DAY, parts[4].toInt())
        set(Calendar.MINUTE, parts[5].toInt())
        set(Calendar.SECOND, parts[6].toInt())
        set(Calendar.MILLISECOND, 0)
    }
    val offsetMinutes = if (parts[7] == "Z") {
        0
    } else {
        val sign = if (parts[8] == "+") 1 else -1
        sign * (parts[9].toInt() * 60 + parts[10].toInt())
    }
    return calendar.timeInMillis - offsetMinutes * 60_000L
}

private val ISO_OFFSET_PATTERN = Regex(
    "(\\d{4})-(\\d{2})-(\\d{2})T(\\d{2}):(\\d{2}):(\\d{2})(Z|([+-])(\\d{2}):(\\d{2}))",
)
