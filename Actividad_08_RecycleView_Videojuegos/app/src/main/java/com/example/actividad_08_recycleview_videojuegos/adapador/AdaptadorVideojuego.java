package com.example.actividad_08_recycleview_videojuegos.adapador;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actividad_08_recycleview_videojuegos.MainEditar;
import com.example.actividad_08_recycleview_videojuegos.R;
import com.example.actividad_08_recycleview_videojuegos.entidad.Videojuego;
import com.example.actividad_08_recycleview_videojuegos.singleton.ListaVideojuegosSingleton;

import java.util.List;

public class AdaptadorVideojuego extends RecyclerView.Adapter<AdaptadorVideojuego.ViewHolder>{
    private List<Videojuego> listaVideojuegos;

    public AdaptadorVideojuego(List<Videojuego> listaVideojuegos){
        this.listaVideojuegos = listaVideojuegos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView nombre;
        private TextView compania;
        private TextView botonEliminar;
        private TextView botonEditar;

        public ViewHolder(View v){
            super(v);
            id = v.findViewById(R.id.idVideojuego);
            nombre = v.findViewById(R.id.nombreVideojuego);
            compania = v.findViewById(R.id.companiaVideojuego);
            botonEliminar = v.findViewById(R.id.botonEliminar);
            botonEditar = v.findViewById(R.id.botonEditar);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.videojuego_detalle, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String sId = String.valueOf(listaVideojuegos.get(position).getId());
        holder.id.setText(sId);
        holder.nombre.setText(listaVideojuegos.get(position).getNombre());
        holder.compania.setText(listaVideojuegos.get(position).getCompania());

        holder.botonEditar.setOnClickListener(view -> {
            Intent intent = new Intent(holder.id.getContext(), MainEditar.class);
            intent.putExtra("id", listaVideojuegos.get(position).getId());
            intent.putExtra("nombre", listaVideojuegos.get(position).getNombre());
            intent.putExtra("compania", listaVideojuegos.get(position).getCompania());
            holder.id.getContext().startActivity(intent);
        });

        holder.botonEliminar.setOnClickListener(view -> {
            Toast.makeText(holder.id.getContext(), "Eliminando usuario " + sId, Toast.LENGTH_SHORT).show();
            ListaVideojuegosSingleton.getInstance().borrar(listaVideojuegos.get(position));
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return listaVideojuegos.size();
    }
}