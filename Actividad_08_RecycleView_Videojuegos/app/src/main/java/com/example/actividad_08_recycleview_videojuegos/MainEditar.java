package com.example.actividad_08_recycleview_videojuegos;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.actividad_08_recycleview_videojuegos.entidad.Videojuego;
import com.example.actividad_08_recycleview_videojuegos.singleton.ListaVideojuegosSingleton;

public class MainEditar extends AppCompatActivity {

    private EditText id, nombre, compania;
    private Button  botonGuardar;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_editar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        id = findViewById(R.id.idEditar);
        nombre = findViewById(R.id.nombreEditar);
        compania = findViewById(R.id.companiaEditar);

        botonGuardar = findViewById(R.id.botonGuardar);

        Bundle extras = getIntent().getExtras();
         if (extras != null){
            int idRecibido = extras.getInt("id", -1);
            if (idRecibido != -1){
                id.setText(String.valueOf(idRecibido));
                id.setEnabled(false);
                nombre.setText(extras.getString("nombre", ""));
                compania.setText(extras.getString("compania", ""));
            }
        }else {
             id.setEnabled(false);
         }

        botonGuardar.setOnClickListener(view -> {
            String nuevoNombre = nombre.getText().toString();
            String nuevaCompania = compania.getText().toString();

            if (id.getText().toString().isEmpty()){
                Log.i("MainEditar", "pasa por el if");
                //Alta
                int nuevoId = ListaVideojuegosSingleton.getInstance().getListaVideojuegos().size() + 1;
                Videojuego nuevoVideojuego = new Videojuego();
                nuevoVideojuego.setId(nuevoId);
                nuevoVideojuego.setNombre(nuevoNombre);
                nuevoVideojuego.setCompania(nuevaCompania);

                ListaVideojuegosSingleton.getInstance().addVideojuego(nuevoVideojuego);
                Log.i("MainEditar", "se agrega el juego");
            }else{
                //Edición
                int idEditado = Integer.parseInt(id.getText().toString());
                for (Videojuego v : ListaVideojuegosSingleton.getInstance().getListaVideojuegos()){
                    if (v.getId() == idEditado){
                        v.setNombre(nuevoNombre);
                        v.setCompania(nuevaCompania);
                        break;
                    }
                }
            }

            finish();
        });
    }
}