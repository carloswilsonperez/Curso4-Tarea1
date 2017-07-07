package com.example.administrador.curso4_tarea1.presentador;

import com.example.administrador.curso4_tarea1.pojo.Perfil;

import java.util.ArrayList;

/**
 * Created by administrador on 25/06/17.
 */

public interface IPerfilFragmentPresenter {

    public void obtenerMediosRecientes(String idUsuario);

    public void mostrarMediosRecientesRv();

    public void obtenerPerfil(String usuario);

    public void setIdUsario(String id);

    public String getIdUsuario();

    public void mostrarPerfil();
}
