package com.example.calculadora_cordobaramos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String botonPresionado = "";
    private TextView consolaCalc;
    private double dato1,dato2, resultado=0, resultadoEnviado,MR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        consolaCalc = (TextView) findViewById(R.id.consolaCalc);
    }



    public void showNumber(View view){

        if(findViewById(R.id.button0).isPressed()){
            botonPresionado +="0";
            consolaCalc.setText(botonPresionado);
        }
        if(findViewById(R.id.button1).isPressed()) {
            botonPresionado += "1";
            consolaCalc.setText(botonPresionado);
        }
        if(findViewById(R.id.button2).isPressed()) {
            botonPresionado += "2" ;
            consolaCalc.setText(botonPresionado);
        }
        if(findViewById(R.id.button3).isPressed()) {
            botonPresionado += "3" ;
            consolaCalc.setText(botonPresionado);
        }
        if(findViewById(R.id.button4).isPressed()) {
            botonPresionado += "4" ;
            consolaCalc.setText(botonPresionado);
        }
        if(findViewById(R.id.button5).isPressed()) {
            botonPresionado += "5" ;
            consolaCalc.setText(botonPresionado);
        }
        if(findViewById(R.id.button6).isPressed()) {
            botonPresionado += "6" ;
            consolaCalc.setText(botonPresionado);
        }
        if(findViewById(R.id.button7).isPressed()) {
            botonPresionado += "7" ;
            consolaCalc.setText(botonPresionado);
        }
        if(findViewById(R.id.button8).isPressed()) {
            botonPresionado += "8" ;
            consolaCalc.setText(botonPresionado);
        }
        if(findViewById(R.id.button9).isPressed()) {
            botonPresionado += "9" ;
            consolaCalc.setText(botonPresionado);
        }
    }

    public void onStartOperation(View view){


        if(findViewById(R.id.dividir).isPressed()) {
            if (resultado != 0 && dato1 !=0) {
                dato1 = resultado;
                botonPresionado = String.valueOf(dato1);
            }else{
                dato1 = Double.parseDouble(botonPresionado);
            }

            botonPresionado += "/" ;
            this.showNumber(view);
        }
        if(findViewById(R.id.multiplicar).isPressed()) {
            if (resultado != 0 && dato1 !=0) {
                dato1 = resultado;
                botonPresionado = String.valueOf(dato1);
            }else{
                dato1 = Double.parseDouble(botonPresionado);
            }
            botonPresionado += "*" ;
            this.showNumber(view);
        }
        if(findViewById(R.id.raiz).isPressed()) {
            if (resultado != 0 && dato1 !=0) {
                dato1 = resultado;
                botonPresionado = String.valueOf(dato1);
            }else{
                dato1 = Double.parseDouble(botonPresionado);
            }
            resultado= Math.sqrt(dato1);
            consolaCalc.setText(String.valueOf(resultado));

            botonPresionado = "";
        }
        if(findViewById(R.id.exponente).isPressed()) {
            if (resultado != 0 && dato1 !=0) {
                dato1 = resultado;
                botonPresionado = String.valueOf(dato1);
            }else{
                dato1 = Double.parseDouble(botonPresionado);
            }
            botonPresionado += "^" ;
            this.showNumber(view);
        }
        if(findViewById(R.id.suma).isPressed()) {
            if (resultado != 0 && dato1 !=0) {
                dato1 = resultado;
                botonPresionado = String.valueOf(dato1);
            }else{
                dato1 = Double.parseDouble(botonPresionado);
            }
            botonPresionado += "+" ;
            this.showNumber(view);
        }
        if(findViewById(R.id.resta).isPressed()) {
            if (resultado != 0 && dato1 !=0) {
                dato1 = resultado;
                botonPresionado = String.valueOf(dato1);
                botonPresionado += "-" ;
                this.showNumber(view);
            }else if (dato1 == 0){
                botonPresionado += "-" ;
                this.showNumber(view);
            }

        }

    }

    public void onPressIgual(View view){
        if(!(botonPresionado.indexOf("/") < 0)){
            dato2= Double.parseDouble(botonPresionado.substring(botonPresionado.indexOf("/")+1));
            if (dato2 == 0){
                popup("No puedes dividir por 0").show();
            }else{
                resultadoEnviado = resultado=(dato1/dato2);
                consolaCalc.setText(String.valueOf(resultado));
                dato1 = 0;
                dato2 = 0;
            }

        }
        if(!(botonPresionado.indexOf("+") < 0)){
            dato2= Double.parseDouble(botonPresionado.substring(botonPresionado.indexOf("+")+1));
            resultadoEnviado = resultado=dato1+dato2;
            consolaCalc.setText(String.valueOf(resultado));
            dato1 = 0;
            dato2 = 0;
            botonPresionado=String.valueOf(resultado);
        }
        if(!(botonPresionado.indexOf("-") < 0)){
            if (botonPresionado.lastIndexOf("-")> 0){
                dato1= Double.parseDouble(botonPresionado.substring(0,botonPresionado.lastIndexOf("-")));
                dato2= Double.parseDouble(botonPresionado.substring(botonPresionado.lastIndexOf("-")));
                resultadoEnviado = resultado=((dato1 * -1)-dato2) * -1;
                consolaCalc.setText(String.valueOf(resultado));
                dato1 = 0;
                dato2 = 0;
            }else{
                dato2= Double.parseDouble(botonPresionado.substring(botonPresionado.indexOf("-")));
                resultadoEnviado = resultado=dato1-dato2;
                consolaCalc.setText(String.valueOf(resultado));
                dato1 = 0;
                dato2 = 0;
            }

        }
        if(!(botonPresionado.indexOf("*") < 0)){
            dato2= Double.parseDouble(botonPresionado.substring(botonPresionado.indexOf("*")+1));
            resultadoEnviado = resultado=dato1*dato2;
            consolaCalc.setText(String.valueOf(resultado));
            dato1 = 0;
            dato2 = 0;
        }
        if(!(botonPresionado.indexOf("^") < 0)){
            dato2= Double.parseDouble(botonPresionado.substring(botonPresionado.indexOf("^")+1));
            resultadoEnviado = resultado=Math.pow(dato1,dato2);
            consolaCalc.setText(String.valueOf(resultado));
            dato1 = 0;
            dato2 = 0;
        }
    }

    public void borrarConsola(View view) {
        botonPresionado="";
        resultado=0;
        consolaCalc.setText("");
    }

    public  void cambiarActivity(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(Intent.EXTRA_TEXT,String.valueOf(resultadoEnviado));
        startActivity(intent);
    }

    public void onSaveMemory(View view){

        MR = resultado;
    }

    public void onRecoveryMemory(View view){
        if (MR == 0){
            popup("No hay nada en memoria").show();
        }
        if(dato1 == 0){
            dato1 = MR;
            botonPresionado += String.valueOf(dato1);
            consolaCalc.setText(botonPresionado);
        }else if(dato2 == 0 && MR != dato1){
            dato2=MR;
            botonPresionado += String.valueOf(dato2);
            consolaCalc.setText(botonPresionado);
        }
    }

    public  Toast popup(CharSequence mensaje){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, mensaje, duration);
        return toast;
    }

}
