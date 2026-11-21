package ai.palab.healthbridge

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
    val recentSevenDays = listOf(
        DailySteps("11월 15일", 6_234),
        DailySteps("11월 16일", 8_120),
        DailySteps("11월 17일", 5_432),
        DailySteps("11월 18일", 10_245),
        DailySteps("11월 19일", 7_310),
        DailySteps("11월 20일", 8_940),
        DailySteps("11월 21일", 6_789),
    )

    fun calculate(days: List<DailySteps> = recentSevenDays): StepSummary = StepSummary(days)
}
