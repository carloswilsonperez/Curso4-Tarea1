package com.example.administrador.curso4_tarea1.restApi.model;

import com.example.administrador.curso4_tarea1.pojo.Perfil;

import java.util.ArrayList;

/**
 * Created by administrador on 02/07/17.
 */

public class PerfilResponse {

    ArrayList<Perfil> perfils;

    public ArrayList<Perfil> getPerfil() {
        return perfils;
    }

    public void setPerfil(ArrayList<Perfil> perfils) {
        this.perfils = perfils;
    }
}
