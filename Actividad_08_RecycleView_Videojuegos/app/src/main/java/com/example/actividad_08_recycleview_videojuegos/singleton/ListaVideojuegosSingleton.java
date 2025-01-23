package com.example.actividad_08_recycleview_videojuegos.singleton;

import com.example.actividad_08_recycleview_videojuegos.adapador.AdaptadorVideojuego;
import com.example.actividad_08_recycleview_videojuegos.entidad.Videojuego;

import java.util.ArrayList;
import java.util.List;

public class ListaVideojuegosSingleton {

    private static  ListaVideojuegosSingleton instance;
    private List<Videojuego> listaVideojuegos;
    private int contador = 1;

    private ListaVideojuegosSingleton(){ super();}

    public static ListaVideojuegosSingleton getInstance(){
        if (instance == null){
            instance = new ListaVideojuegosSingleton();
        }
        return instance;
    }

    public void inicializar(){
        listaVideojuegos = new ArrayList<>();
        Videojuego videojuego = new Videojuego();
        videojuego.setId(contador++);
        videojuego.setNombre("Mario Bross");
        videojuego.setCompania("Nintendo");

        listaVideojuegos.add(videojuego);

        videojuego = new Videojuego();
        videojuego.setId(contador++);
        videojuego.setNombre("Fornite");
        videojuego.setCompania("Epic Games");

        listaVideojuegos.add(videojuego);

        videojuego = new Videojuego();
        videojuego.setId(contador++);
        videojuego.setNombre("Call of Duty");
        videojuego.setCompania("Activision");

        listaVideojuegos.add(videojuego);
    }

    public List<Videojuego> getListaVideojuegos() {
        return listaVideojuegos;
    }
    public void borrar(Videojuego videojuego){
        listaVideojuegos.remove(videojuego);
    }
    public boolean addVideojuego(Videojuego videojuego){
        videojuego.setId(contador++);
        listaVideojuegos.add(videojuego);
        return true;
    }
}
