package com.example.practica1sebastiancandelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ventana3Recibo extends AppCompatActivity {

    private TextView textTitleRecibo, textViewTpagar, textProd, textPre, textCant, textFech, textDes, textTot, textProducto, textPrecio, textCantidad, textFecha, textDescuento, textResult;

    private CheckBox checkBoxCondiciones;

    private Button buttonPagar;

    private Double result;

    private boolean condiciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana3_recibo);
        textTitleRecibo = (TextView) findViewById(R.id.textTitleRecibo);
        textViewTpagar = (TextView) findViewById(R.id.textViewTpagar);
        textProd = (TextView) findViewById(R.id.textProd);
        textPre = (TextView) findViewById(R.id.textPre);
        textCant = (TextView) findViewById(R.id.textCant);
        textFech = (TextView) findViewById(R.id.textFech);
        textDes = (TextView) findViewById(R.id.textDes);
        textTot = (TextView) findViewById(R.id.textTot);
        textProducto = (TextView) findViewById(R.id.textProducto);
        textPrecio = (TextView) findViewById(R.id.textPrecio);
        textCantidad = (TextView) findViewById(R.id.textCantidad);
        textFecha = (TextView) findViewById(R.id.textFecha);
        textDescuento = (TextView) findViewById(R.id.textDescuento);
        textResult = (TextView) findViewById(R.id.textResult);
        checkBoxCondiciones = (CheckBox) findViewById(R.id.checkBoxCondiciones);
        buttonPagar = (Button) findViewById(R.id.buttonPagar);
        result = 0.0;
        condiciones = false;
        Intent intent = getIntent();

        if(intent != null){
            String pack = (String) intent.getStringExtra("producto");
            textProducto.setText(pack);
            String discount = (String) intent.getStringExtra("descuento");
            if(discount.equals("0")){
                textDescuento.setText("20%");
                result = 110.0 - (110.00 * 0.2);
            }else{
                textDescuento.setText("0%");
                result = 110.0;
            }
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = sdf.format(date);
            textFecha.setText(fecha);
            textResult.setText(String.valueOf(result));

        }else{

        }
    }

    public void pagar(View view)
    {
        if(checkBoxCondiciones.isChecked())
        {
            Toast.makeText(this, " se te está redirigiendo para pagar", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Debe aceptar las condiciones", Toast.LENGTH_LONG).show();
        }
    }
}