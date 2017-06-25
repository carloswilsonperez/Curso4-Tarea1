package com.example.administrador.curso4_tarea1.restApi.model;

import com.example.administrador.curso4_tarea1.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by administrador on 19/06/17.
 */
// Clase para manejar la respuesta de la API de Instagram
public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {

        this.mascotas = mascotas;
    }
}
