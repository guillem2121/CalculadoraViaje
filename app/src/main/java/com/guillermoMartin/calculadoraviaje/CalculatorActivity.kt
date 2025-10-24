import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.guillermoMartin.calculadoraviaje.R

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val editTextDistance = findViewById<EditText>(R.id.editTextDistance)
        val editTextConsumption = findViewById<EditText>(R.id.editTextConsumption)
        val editTextPrice = findViewById<EditText>(R.id.editTextPrice)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val buttonBack = findViewById<Button>(R.id.buttonBack)

        buttonCalculate.setOnClickListener {
            val distanceStr = editTextDistance.text.toString()
            val consumptionStr = editTextConsumption.text.toString()
            val priceStr = editTextPrice.text.toString()

            if (distanceStr.isNotEmpty() && consumptionStr.isNotEmpty() && priceStr.isNotEmpty()) {
                val distance = distanceStr.toDouble()
                val consumption = consumptionStr.toDouble()
                val price = priceStr.toDouble()

                // Fórmula: (distancia / 100) * consumo * precio
                val totalCost = (distance / 100) * consumption * price

                val resultText = getString(R.string.result_prefix) + " %.2f".format(totalCost)
                textViewResult.text = resultText

                val toastText = getString(R.string.toast_result, totalCost)
                Toast.makeText(this, toastText, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        buttonBack.setOnClickListener {
            finish() // Cierra la actividad actual y vuelve a la anterior
        }
    }
}