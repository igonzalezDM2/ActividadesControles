package com.example.ejerciciocontroles4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private Button google, yahoo, bing;
    private ImageView visor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        google = findViewById(R.id.google);
        yahoo = findViewById(R.id.yahoo);
        bing = findViewById(R.id.bing);
        visor = findViewById(R.id.visor);
        bing.setOnClickListener(e -> displayPic(R.drawable.bing));
        google.setOnClickListener(e -> displayPic(R.drawable.google));
        yahoo.setOnClickListener(e -> displayPic(R.drawable.yahoo));

    }

    private void displayPic(int pic) {
        visor.setImageResource(pic);
    }

}