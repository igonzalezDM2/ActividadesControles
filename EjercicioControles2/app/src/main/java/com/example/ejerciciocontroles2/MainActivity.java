package com.example.ejerciciocontroles2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button encender;
    Button apagar;
    LinearLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenedor = (LinearLayout) findViewById(R.id.contenedor);
        encender = (Button) findViewById(R.id.encender);
        apagar = (Button) findViewById(R.id.apagar);

        encender.setOnClickListener(e -> changeBack(Color.BLUE));
        apagar.setOnClickListener(e -> changeBack(Color.DKGRAY));
    }

    private void changeBack(int color) {
        contenedor.setBackgroundColor(color);
    }

}