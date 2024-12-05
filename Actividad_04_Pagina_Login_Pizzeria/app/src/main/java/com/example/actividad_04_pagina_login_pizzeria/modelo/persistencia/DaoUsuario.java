package com.example.actividad_04_pagina_login_pizzeria.modelo.persistencia;

import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Pizza;
import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Usuario;

import java.util.ArrayList;
import java.util.List;

public class  DaoUsuario{

    private static DaoUsuario  instace = null;

    private List<Usuario> listaUsuarios;

    private DaoUsuario(){
        listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario("Laura", "L1234", "Calle3"));
        listaUsuarios.add(new Usuario("Pedro", "P4321", "Calle2"));
        listaUsuarios.add(new Usuario("Pepe", "P5678", "Calle5"));
    }

    public static DaoUsuario getInstance() {
        if(instace == null){
            instace = new DaoUsuario();
        }
        return instace;
    }

    public Usuario buscarUsuario(String nombre){
        for (Usuario u : listaUsuarios){
            if (u.getNombre().equals(nombre)){
                return u;
            }
        }
        return null;
    }

    public boolean addUsuario(Usuario user){
        listaUsuarios.add(user);
        return true;
    }
}
