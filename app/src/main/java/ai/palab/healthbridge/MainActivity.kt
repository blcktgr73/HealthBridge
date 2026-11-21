package ai.palab.healthbridge

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val summary = SyntheticStepSummary.calculate()
        findViewById<TextView>(R.id.total_steps).text =
            getString(R.string.total_steps, summary.totalSteps)
        findViewById<TextView>(R.id.average_steps).text = getString(
            R.string.average_steps,
            String.format(Locale.getDefault(), "%,.1f", summary.averageSteps),
        )
        findViewById<TextView>(R.id.daily_steps).text = summary.days.joinToString("\n") { day ->
            getString(R.string.daily_steps, day.dateLabel, day.steps)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
