package com.example.actividad_04_pagina_login_pizzeria;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Usuario;

public class ActivityCalcularPrecio extends AppCompatActivity {
    private TextView textViewResumen;
    private TextView textViewUsuario;
    private TextView textViewResumen1;
    private TextView pedidoProccesado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_precio);

        pedidoProccesado = findViewById(R.id.textViewResumen);
        textViewResumen1 = findViewById(R.id.textViewResumen1);
        textViewUsuario = findViewById(R.id.textViewUsuario);

        Usuario usuario = (Usuario)getIntent().getSerializableExtra("usuario");
        Log.d("ActivityCalcularPrecio", "Usuario" + usuario);
        textViewResumen = findViewById(R.id.textViewResumen);
        textViewUsuario.setText("Usuario: " + usuario.getNombre());
        textViewResumen1.setText("Resumen del pedido: " + usuario.getPizza());

        Log.d("ActivityCalcularPrecio", "Usuario: " + usuario + ", Pizza: " + usuario.getPizza());

    }
}