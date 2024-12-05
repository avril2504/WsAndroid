   package com.example.actividad_05_calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLogin extends AppCompatActivity {
    private EditText nombreUsuario;
    private Button botonCalculadora;

    public final static String K_USUARIO = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        botonCalculadora = findViewById(R.id.botonCalculadora);
        nombreUsuario = findViewById(R.id.nombreUsuario);

        botonCalculadora.setOnClickListener(view -> {
            String usuario = nombreUsuario.getText().toString();

            Intent intentCalculadora = new Intent(ActivityLogin.this,ActivityCalculadora.class);
            intentCalculadora.putExtra("usuario", usuario);
            startActivity(intentCalculadora);
        });
    }
}