package com.example.ejerciciocontroles5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.slider.Slider;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    final static NumberFormat FORMATTER = new DecimalFormat("#0.00");

    private Slider slider;
    private TextView tmp;
    private TextView abiertas;

    private ToggleButton cam;
    private TextView camTxt;

    Switch swhab;
    Switch swsalon;
    Switch swcoc;


    private void persianasAbiertas() {
        String txt = "";
        if (swhab.isChecked()) {
            txt += "Habitación\n";
        }
        if (swcoc.isChecked()) {
            txt += "Cocina\n";
        }
        if (swsalon.isChecked()) {
            txt += "Salón";
        }
        abiertas.setText(txt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        slider = findViewById(R.id.slider);
        tmp = findViewById(R.id.tmp);

        abiertas = findViewById(R.id.abiertas);

        swhab = findViewById(R.id.switchpersianahabitacion);
        swhab.setOnClickListener(e -> persianasAbiertas());
        swsalon = findViewById(R.id.switchpersianasalon);
        swsalon.setOnClickListener(e -> persianasAbiertas());
        swcoc = findViewById(R.id.switchpersianacocina);
        swcoc.setOnClickListener(e -> persianasAbiertas());


        camTxt = findViewById(R.id.camarastext);
        cam = findViewById(R.id.camaras);
        cam.setOnClickListener(e -> {
            if (cam.isChecked()) {
                camTxt.setText("Las cámaras están grabando");
            } else {
                camTxt.setText("Las cámaras NO están grabando");
            }
        });

        tmp.setText("Temperatura establecida: 20ºC");
        slider.addOnChangeListener((slider, value, fromUser) -> {
            tmp.setText("Temperatura establecida: " + FORMATTER.format(value) + "ºC");
        });
    }
}