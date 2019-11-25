package com.example.calculadora_cordobaramos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static android.content.Intent.EXTRA_TEXT;

public class Main2Activity extends AppCompatActivity {

    private  String lastResult ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extra = getIntent().getExtras();
        String mensaje = extra.getString(EXTRA_TEXT);
        lastResult = mensaje;
        TextView textView = (TextView) findViewById(R.id.resultadoAnterior);
        textView.setText("El resultado de la última operación es: \n" + lastResult);
    }
}

