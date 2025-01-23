package com.example.actividad_08_recycleview_videojuegos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actividad_08_recycleview_videojuegos.adapador.AdaptadorVideojuego;
import com.example.actividad_08_recycleview_videojuegos.entidad.Videojuego;
import com.example.actividad_08_recycleview_videojuegos.singleton.ListaVideojuegosSingleton;

import java.util.List;

public class MainVideojuego extends AppCompatActivity {

    private RecyclerView recyclerViewVideojuego;
    private AdaptadorVideojuego adaptadorVideojuego;
    private Button botonAlta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.videojuego_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerViewVideojuego = findViewById(R.id.rViewVideojuego);
        botonAlta = findViewById(R.id.botonAlta);

        recyclerViewVideojuego.setHasFixedSize(true);
        recyclerViewVideojuego.setLayoutManager(new LinearLayoutManager(this));

        ListaVideojuegosSingleton.getInstance().inicializar();
        List<Videojuego> listaVideojuego = ListaVideojuegosSingleton.getInstance().getListaVideojuegos();

        adaptadorVideojuego = new AdaptadorVideojuego(listaVideojuego);
        recyclerViewVideojuego.setAdapter(adaptadorVideojuego);

        botonAlta.setOnClickListener(view -> {
            Intent intent = new Intent(MainVideojuego.this, MainEditar.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        List<Videojuego> listaVideojuego = ListaVideojuegosSingleton.getInstance().getListaVideojuegos();
        adaptadorVideojuego.notifyDataSetChanged();
    }
}