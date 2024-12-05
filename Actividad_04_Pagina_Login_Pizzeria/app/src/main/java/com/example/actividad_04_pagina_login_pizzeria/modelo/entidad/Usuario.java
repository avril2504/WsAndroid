package com.example.actividad_04_pagina_login_pizzeria.modelo.entidad;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String password;
    private String direccion;
    private Pizza pizza;

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public Usuario(String nombre, String password, String direccion) {
        this.nombre = nombre;
        this.password = password;
        this.direccion = direccion;
    }

    public Usuario(String nombre, String password, String direccion, Pizza pizza) {
        this.nombre = nombre;
        this.password = password;
        this.direccion = direccion;
        this.pizza = pizza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pizza getPizza() {
        return pizza;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pizza=" + pizza +
                '}';
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;



    }
}
