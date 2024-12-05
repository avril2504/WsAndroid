package com.example.actividad_04_pagina_login_pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Usuario;

public class ActivityRegistrar extends AppCompatActivity {

    private EditText nombreUsuario, passUsuario, direccionUsuario;
    private Button botonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registrar);

        nombreUsuario = findViewById(R.id.nombreUsuarioRegistrado);
        direccionUsuario = findViewById(R.id.direccionRegistrado);
        passUsuario = findViewById(R.id.passUsuarioRegistrado);

        botonRegistrar = findViewById(R.id.botonRegresar);

        botonRegistrar.setOnClickListener(view -> {
            String nuevoNombre = nombreUsuario.getText().toString();
            String nuevoPass = passUsuario.getText().toString();
            String nuevaDireccion = direccionUsuario.getText().toString();

            if (!nuevoNombre.isEmpty() && !nuevoPass.isEmpty()){
                Usuario nuevoUsuario = new Usuario(nuevoNombre, nuevoPass, nuevaDireccion);

                Intent intent = new Intent(ActivityRegistrar.this,ActivityLogin.class);
                intent.putExtra("nuevoUsuario", nuevoUsuario);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}