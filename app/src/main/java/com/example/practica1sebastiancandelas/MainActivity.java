package com.example.practica1sebastiancandelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView titleTextView, textChoose, textMarinMain, textXenosMain, textMain;
    private ImageButton buttonMarines, buttonXenos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        textChoose = (TextView) findViewById(R.id.textChoose);
        textMarinMain = (TextView) findViewById(R.id.textMarinMain);
        textXenosMain = (TextView) findViewById(R.id.textXenosMain);
        textMain = (TextView) findViewById(R.id.textMain);
        buttonMarines = (ImageButton) findViewById(R.id.buttonMarines);
        buttonXenos = (ImageButton) findViewById(R.id.buttonXenos);
    }

    public void siguienteXenos (View view){
        Intent siguiente = new Intent(this, Ventana2Xenos.class);
        startActivity(siguiente);
    }

    public void siguienteMarines (View view){
        Intent siguiente = new Intent(this, Ventana2Marines.class);
        startActivity(siguiente);
    }


}