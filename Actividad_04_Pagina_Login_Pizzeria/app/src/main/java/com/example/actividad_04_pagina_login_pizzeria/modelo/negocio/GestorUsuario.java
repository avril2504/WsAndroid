package com.example.actividad_04_pagina_login_pizzeria.modelo.negocio;

import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Pizza;
import com.example.actividad_04_pagina_login_pizzeria.modelo.entidad.Usuario;
import com.example.actividad_04_pagina_login_pizzeria.modelo.persistencia.DaoUsuario;

public class GestorUsuario {

    private static GestorUsuario instance = null;

    private DaoUsuario dao;

    private GestorUsuario(){
        super();
    }

    public static GestorUsuario getInstance(){
        if (instance == null){
            instance = new GestorUsuario();
        }
        return instance;
    }

    /**
     * Metodo que valida un usuario a base de su nombre y password. Ambos
     * campos deben coincidir con los campos del array list.
     * @param u usuario a validar
     * @return usuarios en caso de que este coincida con el del array list, null en caso que
     * el usuario no sea valido o su password no coincida.
     */
    public Usuario entrar(Usuario u){
        dao = DaoUsuario.getInstance();
       Usuario usuarios = dao.buscarUsuario(u.getNombre());
       if (usuarios != null){
           if (u.getPassword().equals(usuarios.getPassword())){
               return usuarios;
           }
       }
       return null;
    }

public boolean registrar(Usuario usuario){
    dao = DaoUsuario.getInstance();
    return dao.addUsuario(usuario);

    }

}
