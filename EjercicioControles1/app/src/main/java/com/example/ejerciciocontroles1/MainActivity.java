package com.example.ejerciciocontroles1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText valor1;
    private EditText valor2;
    private TextView resultado;


    private Button botonMas;
    private Button botonMenos;
    private Button botonPor;
    private Button botonEntre;

    @FunctionalInterface
    static interface ResultCallback {
        public Double run(Double value1, Double value2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor1 = (EditText) findViewById(R.id.valor1);
        valor2 = (EditText) findViewById(R.id.valor2);
        resultado = (TextView) findViewById(R.id.resultado);

        botonMas = (Button) findViewById(R.id.BtnMas);
        botonMenos= (Button) findViewById(R.id.BtnMenos);
        botonPor= (Button) findViewById(R.id.BtnPor);
        botonEntre= (Button) findViewById(R.id.BtnEntre);

        botonMas.setOnClickListener((e) -> {
            Double v1 = getValue(valor1);
            Double v2 = getValue(valor2);
            displayResult(v1 + v2);
        });

        botonMas.setOnClickListener((e) -> operate((v1,  v2) -> v1 + v2));
        botonMenos.setOnClickListener((e) -> operate((v1,  v2) -> v1 - v2));
        botonPor.setOnClickListener((e) -> operate((v1,  v2) -> v1 * v2));
        botonEntre.setOnClickListener((e) -> operate((v1,  v2) -> v1 / v2));

    }

    private void operate(ResultCallback callback) {
        Double v1 = getValue(valor1);
        Double v2 = getValue(valor2);
        displayResult(callback.run(v1, v2));
    }

    private Double getValue(EditText editText) {
        String txt = editText.getText() != null ? editText.getText().toString() : null;
        if (txt != null && !txt.isEmpty()) {
            try {
                return Double.parseDouble(txt);
            } catch (NumberFormatException e) {
                //No hacer nada
            }
        }
        return 0d;
    }

    private void displayResult(Double result) {
        String resultTxt = result != null ? result.toString() : "";
        resultado.setText(resultTxt);
    }
}