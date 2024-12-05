package com.example.actividad_03_pizzera;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioButton grande;
    private RadioButton mediana;
    private RadioButton pequena;

    private CheckBox pepperoni;
    private CheckBox maiz;
    private CheckBox jamon;
    private CheckBox bacon;
    private CheckBox aceitunas;
    private EditText total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grande = findViewById(R.id.grande);
        mediana = findViewById(R.id.mediana);
        pequena = findViewById(R.id.pequena);

        pepperoni = findViewById(R.id.pepperoni);
        maiz = findViewById(R.id.maiz);
        jamon = findViewById(R.id.jamon);
        bacon = findViewById(R.id.bacon);
        aceitunas = findViewById(R.id.aceitunas);
        total = findViewById(R.id.totalprecio);

        Button precio = findViewById(R.id.bontonprecio);
        precio.setOnClickListener(view -> calcular());


    }

    @SuppressLint("SetTextI18n")
    private void calcular(){
        int precioBase = 0;

        if(grande.isChecked()){
            precioBase = 15;
        }else if(mediana.isChecked()){
            precioBase = 10;
        }else if(pequena.isChecked()){
            precioBase = 5;
        }

        int precioTotal = precioBase;

        if (pepperoni.isChecked()){
            precioTotal += 2;
        }

        if (maiz.isChecked()){
            precioTotal += 2;
        }

        if (jamon.isChecked()){
            precioTotal += 2;
        }

        if (bacon.isChecked()){
            precioTotal += 2;
        }

        if (aceitunas.isChecked()){
            precioTotal += 2;
        }

        total.setText("€"+precioTotal);
    }
}