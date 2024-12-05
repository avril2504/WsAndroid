package com.example.actividad_04_pagina_login_pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Usuario;
import com.example.actividad_04_pagina_login_pizzeria.modelo.negocio.GestorUsuario;

public class   ActivityLogin extends AppCompatActivity {
    private Button botonActivityPizzeria;
    private Button botonRegistro;
    private EditText textoNombreUsuario,textoPasswordUsuario;
    private TextView error;
    private static final String K_ERROR = "error";

    private final static String K_NOMBRE_USUARIO = "nombre";
    private final static String K_PASSWORD_USUARIO = "pass";
    private final static String K_USUARIO = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ActivityLogin", "onCreate() llamado");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        botonActivityPizzeria = findViewById(R.id.botonLogin);
        botonRegistro = findViewById(R.id.botonSingnup);
        textoNombreUsuario = findViewById(R.id.nombreUsuario);
        textoPasswordUsuario = findViewById(R.id.passUsuario);
        error = findViewById(R.id.tvError);

        if (savedInstanceState != null) {
            String errorMensaje = savedInstanceState.getString(K_ERROR);
            if (errorMensaje != null) {
                error.setText(errorMensaje);
                error.setVisibility(TextView.VISIBLE);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLogin", "onStart() llamado");

        final ActivityResultLauncher<Intent> registerLauncher =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->{
                    if(result.getResultCode() == RESULT_OK && result.getData() != null){
                        Intent data = result.getData();

                        Usuario nuevoUsuario = (Usuario)data.getSerializableExtra("nuevoUsuario");

                        boolean ok = GestorUsuario.getInstance().registrar(nuevoUsuario);

                        if(ok){
                            textoNombreUsuario.setText(nuevoUsuario.getNombre());
                            textoPasswordUsuario.setText(nuevoUsuario.getPassword());
                        }else{
                            error.setText("No se ha podido registrar");
                        }
                    }
                });

        botonRegistro.setOnClickListener(view -> {
            Intent intent = new Intent(ActivityLogin.this, ActivityRegistrar.class);
            registerLauncher.launch(intent);
        });

        botonActivityPizzeria.setOnClickListener(view -> {
            String nombre = textoNombreUsuario.getText().toString();
            String password = textoPasswordUsuario.getText().toString();

            Usuario usuarioValidar = new Usuario(nombre,password);
            Usuario usuarioValidado = GestorUsuario.getInstance().entrar(usuarioValidar);

            if (usuarioValidado != null){
                Intent intent = new Intent(ActivityLogin.this,ActivityPizzeria.class);
                intent.putExtra("usuario", usuarioValidado);
                startActivity(intent);
            }else{
                error.setVisibility(view.VISIBLE);
                error.setText("NO se puede acceder, usuario o contraaseña incorrecta");
            }

        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (error.getVisibility() == TextView.VISIBLE){
            outState.putString(K_ERROR, error.getText().toString());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLogin", "onPause() llamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLogin", "onStop() llamado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLogin", "onRestart() llamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLogin", "onDestroy() llamado");
    }
}