package com.example.actividad_04_pagina_login_pizzeria.modelo.negocio;

import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Pizza;

import java.util.List;

public class GestorPizza {

    public Pizza crearPizza(String tamano, List<String> ingredientes){
        double precio = calcularPrecio(tamano, ingredientes);
        return new Pizza(tamano, ingredientes, precio);
    }

    private double calcularPrecio(String tamano, List<String> ingredientes){
        double precioBase;

        switch (tamano.toLowerCase()){
            case "pequena":
                precioBase = 5.00;
                break;
            case "media":
                precioBase = 10.00;
                break;
            case "grande":
                precioBase = 15.00;
                break;
            default:
                precioBase = 10.00;
        }

        double precioIngredientes = ingredientes.size() * 2;
        return precioBase + precioIngredientes;
    }
}
