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

public class Ventana2Xenos extends AppCompatActivity {

    private TextView txtTitleXenos, textXenos;

    private ImageButton imageButtonBack;

    private Button buttonComprarXenos;

    private Spinner spinnerXenos;

    private CheckBox checkBoxXenos;

    private String pack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_xenos);
        //Inicializar Componentes
        txtTitleXenos = (TextView) findViewById(R.id.txtTitleXenos);
        textXenos = (TextView) findViewById(R.id.textXenos);
        imageButtonBack = (ImageButton) findViewById(R.id.imageButtonBack);
        buttonComprarXenos = (Button) findViewById(R.id.buttonComprarXenos);
        spinnerXenos = (Spinner) findViewById(R.id.spinnerXenos);
        checkBoxXenos = (CheckBox) findViewById(R.id.checkBoxXenos);
        pack = "";

        String packXenos[] = {"Aeldari Starter Pack","Tyranids Starter Pack","Necrons Starter Pack", "Orks Starter Pack", "T`AU Starter Pack"};
        ArrayAdapter<String> adapterPacks = new ArrayAdapter<String>(this, R.layout.spinner_item_productos,packXenos);
        spinnerXenos.setAdapter(adapterPacks);
        spinnerXenos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    public void comprarXenos(View view){
        int ventana = 0;
        Intent siguiente = new Intent(this, Ventana3Recibo.class);
        if (checkBoxXenos.isChecked()){
            siguiente.putExtra("descuento", "0");
        }else {
            siguiente.putExtra("descuento", "1");
        }
        siguiente.putExtra("producto", pack);
        startActivity(siguiente);
    }
}