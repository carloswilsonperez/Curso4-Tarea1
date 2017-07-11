package com.example.administrador.curso4_tarea1.presentador;

import com.example.administrador.curso4_tarea1.pojo.Perfil;

import java.util.ArrayList;

/**
 * Created by administrador on 25/06/17.
 */

public interface IPerfilFragmentPresenter {

    public void obtenerMediosRecientes();

    public void mostrarMediosRecientesRv();

    public void obtenerPerfil();

    public void obtenerIdPerfil(String usuario);

    public void enviarIdPerfil();

    public void mostrarPerfil();
}
