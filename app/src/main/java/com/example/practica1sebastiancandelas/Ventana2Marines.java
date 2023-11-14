package com.example.practica1sebastiancandelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Ventana2Marines extends AppCompatActivity {

    private TextView txtTitleMarines, textMarines;

    private ImageButton imageButtonBack;

    private Button buttonComprarMarines;

    private Spinner spinnerMarines;

    private CheckBox checkBoxMarines;

    private String pack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_marines);
        //Inicializar componentes
        txtTitleMarines = (TextView) findViewById(R.id.txtTitleMarines);
        textMarines = (TextView) findViewById(R.id.textMarines);
        imageButtonBack = (ImageButton) findViewById(R.id.imageButtonBack);
        buttonComprarMarines = (Button) findViewById(R.id.buttonComprarMarines);
        spinnerMarines = (Spinner) findViewById(R.id.spinnerMarines);
        checkBoxMarines = (CheckBox) findViewById(R.id.checkBoxMarines);
        pack = "Ultra Marines Starter Pack";
        //---------------------------------------------------------------
        String packMarines[] = {"Ultra Marines Starter Pack","Black Templars Starter Pack","Death Watch Starter Pack", "Grey Knights Starter Pack"};
        ArrayAdapter<String> adapterPacks = new ArrayAdapter<String>(this, R.layout.spinner_item_productos,packMarines);
        spinnerMarines.setAdapter(adapterPacks);
        spinnerMarines.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                pack = String.valueOf(adapterPacks.getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                pack = String.valueOf(adapterPacks.getItem(0));
            }
        });
    }

    public void volver(View view){
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

    public void comprarMarines(View view){
        int ventana = 0;
        Intent siguiente = new Intent(this, Ventana3Recibo.class);
        if (checkBoxMarines.isChecked()){
            siguiente.putExtra("descuento", "0");
        }else {
            siguiente.putExtra("descuento", "1");
        }
        siguiente.putExtra("producto", pack);
        startActivity(siguiente);
    }
}