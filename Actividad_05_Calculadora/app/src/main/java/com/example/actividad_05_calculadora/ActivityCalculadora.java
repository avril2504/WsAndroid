package com.example.actividad_05_calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class ActivityCalculadora extends AppCompatActivity {
    private EditText usuario;
    private EditText resultado;
    private Button n0;
    private Button n1;
    private Button n2;
    private Button n3;
    private Button n4;
    private Button n5;
    private Button n6;
    private Button n7;
    private Button n8;
    private Button n9;
    private Button punto;
    private Button igual;
    private Button suma;
    private Button resta;
    private Button multiplicacion;
    private Button division;
    private Button c;

    double valor1 = 0;
    double valor2 = 0;
    String operador = "";
    boolean operadorselect = false;
    boolean puntoselect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        usuario = findViewById(R.id.nombreUsuarioCal);

        Intent intent = getIntent();
        String usuarioRecibido = intent.getStringExtra(ActivityLogin.K_USUARIO);

        // Mostrar el nombre de usuario en el EditText
        if (usuarioRecibido != null) {
            usuario.setText(usuarioRecibido);
        }

        resultado = findViewById(R.id.resultado);
        n0 = findViewById(R.id.n0);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        n7 = findViewById(R.id.n7);
        n8 = findViewById(R.id.n8);
        n9 = findViewById(R.id.n9);
        punto = findViewById(R.id.punto);
        igual = findViewById(R.id.igual);
        suma = findViewById(R.id.suma);
        resta = findViewById(R.id.resta);
        multiplicacion = findViewById(R.id.multiplicacion);
        division = findViewById(R.id.division);
        c = findViewById(R.id.C);

        Button[] buttons = {n0, n1, n2, n3, n4, n5, n6, n7, n8, n9};

        for (int i = 0; i < buttons.length; i++) {
            final int number = i; // Número asociado al botón
            buttons[i].setOnClickListener(view -> {
                // Aquí agregas el número al texto de la pantalla o variable que almacene el número
                resultado.setText(resultado.getText() + String.valueOf(number));
            });
        }

        punto.setOnClickListener(view -> {
            if(!puntoselect){
                resultado.setText(resultado.getText() + ".");
                puntoselect = true;
            }
        });

        suma.setOnClickListener(view -> {
            valor1 = Double.parseDouble(resultado.getText().toString());
            operador = "+";
            resultado.setText("");
            puntoselect = false;
        });

        resta.setOnClickListener(view -> {
            valor1 = Double.parseDouble(resultado.getText().toString());
            operador = "-";
            resultado.setText("");
            puntoselect = false;
        });

        multiplicacion.setOnClickListener(view -> {
            valor1 = Double.parseDouble(resultado.getText().toString());
            operador = "*";
            resultado.setText("");
            puntoselect = false;
        });

        division.setOnClickListener(view -> {
            valor1 = Double.parseDouble(resultado.getText().toString());
            operador = "/";
            resultado.setText("");
            puntoselect = false;
        });

        igual.setOnClickListener(view -> {
            valor2 = Double.parseDouble(resultado.getText().toString());
            double result = 0;

            switch (operador) {
                case "+":
                    result = valor1 + valor2;
                break;
                case "-":
                    result = valor1 - valor2;
                break;
                case "*":
                    result = valor1 * valor2;
                break;
                case "/":
                    result = valor1 / valor2;
                break;
            }
            resultado.setText(String.valueOf(result));
        });

        c.setOnClickListener(view -> {
            resultado.setText("");
            valor1 = 0;
            valor2 = 0;
            operador = "";
        });
    }
}
