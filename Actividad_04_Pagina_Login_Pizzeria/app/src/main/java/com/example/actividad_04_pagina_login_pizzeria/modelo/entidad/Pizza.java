package com.example.actividad_04_pagina_login_pizzeria.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {

    private String tamano;
    private List<String> ingredientes;
    private double precio;

    public Pizza(String tamano, List<String> ingredientes, double precio) {
        this.tamano = tamano;
        this.ingredientes = ingredientes;
        this.precio = precio;
    } 

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "tamano='" + tamano + '\'' +
                ", ingredientes=" + ingredientes +
                ", precio=" + precio +
                '}';
    }

    public void setPrecio(double precio) {
        this.precio = precio;

    }
}
