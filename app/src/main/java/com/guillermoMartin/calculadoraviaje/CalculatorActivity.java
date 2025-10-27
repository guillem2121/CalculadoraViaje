package com.guillermoMartin.calculadoraviaje;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        EditText editTextDistance = findViewById(R.id.editTextDistance);
        EditText editTextConsumption = findViewById(R.id.editTextConsumption);
        EditText editTextPrice = findViewById(R.id.editTextPrice);
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        TextView textViewResult = findViewById(R.id.textViewResult);
        Button buttonBack = findViewById(R.id.buttonBack);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String distanceStr = editTextDistance.getText().toString();
                String consumptionStr = editTextConsumption.getText().toString();
                String priceStr = editTextPrice.getText().toString();

                if (!distanceStr.isEmpty() && !consumptionStr.isEmpty() && !priceStr.isEmpty()) {
                    double distance = Double.parseDouble(distanceStr);
                    double consumption = Double.parseDouble(consumptionStr);
                    double price = Double.parseDouble(priceStr);

                    double totalCost = (distance / 100) * consumption * price;

                    String resultText = getString(R.string.result_prefix) + String.format("%.2f", totalCost);
                    textViewResult.setText(resultText);

                    String toastText = getString(R.string.toast_result, totalCost);
                    Toast.makeText(CalculatorActivity.this, toastText, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(CalculatorActivity.this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}