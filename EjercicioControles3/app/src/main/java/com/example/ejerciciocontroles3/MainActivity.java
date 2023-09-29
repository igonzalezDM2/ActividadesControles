package com.example.ejerciciocontroles3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static char[] ARR_LETRAS = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B','N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    EditText etNum;
    EditText etLet;
    Button btnValidar;
    TextView tvRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum = findViewById(R.id.numdni);
        etLet = findViewById(R.id.letradni);
        btnValidar = findViewById(R.id.botonvalidar);
        tvRes = findViewById(R.id.resultado);

        btnValidar.setOnClickListener(e -> validar());
    }

    private void validar() {
        String strNum = etNum.getText().toString();
        String letraStr = etLet.getText().toString();
        if (strNum != null && strNum.length() == 8 && letraStr != null && letraStr.length() == 1) {
            try {
                char letra = letraStr.charAt(0);
                long num = Long.parseLong(strNum);
                int resto = (int) (num % 23);
                char letraCorrecta = ARR_LETRAS[resto];
                if (letraCorrecta == Character.toUpperCase(letra)) {
                    tvRes.setText("CORRECTO");

                } else {
                    tvRes.setText("INCORRECTO");
                }

            } catch (Exception e) {
                tvRes.setText("DATOS ERRÓNEOS");
            }
        } else {
            tvRes.setText("DATOS ERRÓNEOS");
        }

    }


}