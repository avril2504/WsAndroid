package com.example.actividad_04_pagina_login_pizzeria;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Pizza;
import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Usuario;
import com.example.actividad_04_pagina_login_pizzeria.modelo.negocio.GestorPizza;

import java.util.ArrayList;
import java.util.List;

public class ActivityPizzeria extends AppCompatActivity {

    private RadioButton grande;
    private RadioButton mediana;
    private RadioButton pequena;
    private CheckBox pepperoni, maiz, jamon, bacon, aceitunas;
    private EditText nombreUsuario, direccion;
    private Button botonPrecio;
    private TextView error;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzeria);
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        GestorPizza gp = new GestorPizza();

        grande = findViewById(R.id.grande);
        mediana = findViewById(R.id.mediana);
        pequena = findViewById(R.id.pequena);
        pepperoni = findViewById(R.id.pepperoni);
        maiz = findViewById(R.id.maiz);
        jamon = findViewById(R.id.jamon);
        bacon = findViewById(R.id.bacon);
        aceitunas = findViewById(R.id.aceitunas);
        nombreUsuario = findViewById(R.id.nombreCreaPizza);
        direccion = findViewById(R.id.direccionCreaPizza);
        botonPrecio = findViewById(R.id.bontonPrecio);

        error = findViewById(R.id.textViewError);

        nombreUsuario.setText(usuario.getNombre());
        direccion.setText(usuario.getDireccion());

        botonPrecio.setOnClickListener(view -> {
            String tamanio = null;
            if (pequena.isChecked()){
                tamanio = "pequena";
            } else if (mediana.isChecked()) {
                tamanio = "mediana";
            }else if (grande.isChecked()){
                tamanio = "grande";
            }

            if (tamanio == null){
                error.setText("Por favor, seleccione el tamaño de la pizza");
                return;
            }
                List<String> listaIngredientes = new ArrayList<>();
                if (pepperoni.isChecked()){
                    listaIngredientes.add("pepperoni");
                }

                if (maiz.isChecked()){
                    listaIngredientes.add("maiz");
                }

                if (jamon.isChecked()){
                    listaIngredientes.add("jamon");
                }

                if (bacon.isChecked()){
                    listaIngredientes.add("bacon");
                }

                if (aceitunas.isChecked()){
                    listaIngredientes.add("aceitunas");
                }

                if (listaIngredientes.size() == 0){
                    error.setText("Por favor, agregue ingredientes a la pizza");
                    return;
                }

                Pizza pizza = gp.crearPizza(tamanio, listaIngredientes);
                usuario.setPizza(pizza);
                Log.i("ActivityPizzeria", "Pizza" + pizza);
                Intent intent = new Intent(ActivityPizzeria.this,ActivityCalcularPrecio.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);

        });

    }
}