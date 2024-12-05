package com.example.actividad_01_minicalculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText n1;
    private EditText n2;
    private EditText resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.numero1);
        n2 = findViewById(R.id.numero2);
        resultado = findViewById(R.id.resultado);

        Button sumar = findViewById(R.id.sumar);
        sumar.setOnClickListener(view ->{
            if(estaVacio()){

                double suma = Double.parseDouble(n1.getText().toString().trim()) +
                              Double.parseDouble(n2.getText().toString().trim());
                resultado.setText(String.valueOf(suma));
            }

        });

        Button restar = findViewById(R.id.restar);
        restar.setOnClickListener(view -> {
            if(estaVacio()){

                double resta = Double.parseDouble(n1.getText().toString().trim()) -
                               Double.parseDouble(n2.getText().toString().trim());
                resultado.setText(String.valueOf(resta));
            }
        });

        Button multiplicar = findViewById(R.id.multiplicar);
        multiplicar.setOnClickListener(view -> {
            if(estaVacio()){
                double multiplicacion = Double.parseDouble(n1.getText().toString().trim()) *
                                        Double.parseDouble(n2.getText().toString().trim());
                resultado.setText(String.valueOf(multiplicacion));
            }
        });

        Button dividir = findViewById(R.id.dividir);
        dividir.setOnClickListener(view -> {
            if(estaVacio()){
                double division = Double.parseDouble(n1.getText().toString().trim()) /
                        Double.parseDouble(n2.getText().toString().trim());
                resultado.setText(String.valueOf(division));
            }
        });

        Button potencia = findViewById(R.id.potencia);
        potencia.setOnClickListener(view -> {
            if (estaVacio()) {
                double base = Double.parseDouble(n1.getText().toString().trim());
                double exponente = Double.parseDouble(n2.getText().toString().trim());
                double resultadoPotencia = Math.pow(base, exponente);
                resultado.setText(String.valueOf(resultadoPotencia));

            }
        });

        Button borrar = findViewById(R.id.borrar);
        borrar.setOnClickListener(view -> {
            n1.setText("");
            n2.setText("");
            resultado.setText("");
        });

    }

    private boolean estaVacio(){
        String campo1 = n1.getText().toString().trim();
        String campo2 = n2.getText().toString().trim();

        if(campo1.isEmpty() || campo2.isEmpty()){
            resultado.setText("Por favor introduzca los dos números");
            return false;
        }
        return true;
    }
}