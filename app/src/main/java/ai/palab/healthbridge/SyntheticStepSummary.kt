package ai.palab.healthbridge

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

data class DailySteps(
    val dateLabel: String,
    val steps: Int,
)

data class StepSummary(
    val days: List<DailySteps>,
) {
    val totalSteps: Int
        get() = days.sumOf { it.steps }

    val averageSteps: Double
        get() = if (days.isEmpty()) 0.0 else totalSteps.toDouble() / days.size
}

object SyntheticStepSummary {
    private val sampleSteps = listOf(6_234, 8_120, 5_432, 10_245, 7_310, 8_940, 6_789)

    fun recentSevenDays(today: Calendar = Calendar.getInstance()): List<DailySteps> {
        val date = today.clone() as Calendar
        date.add(Calendar.DAY_OF_YEAR, -6)
        val formatter = SimpleDateFormat("M월 d일", Locale.KOREAN).apply {
            timeZone = date.timeZone
        }
        return sampleSteps.map { steps ->
            DailySteps(formatter.format(date.time), steps).also {
                date.add(Calendar.DAY_OF_YEAR, 1)
            }
        }
    }

    fun calculate(days: List<DailySteps> = recentSevenDays()): StepSummary = StepSummary(days)
}
