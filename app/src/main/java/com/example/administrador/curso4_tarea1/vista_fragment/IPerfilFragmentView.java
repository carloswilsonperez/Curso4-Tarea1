package com.example.administrador.curso4_tarea1.vista_fragment;

import com.example.administrador.curso4_tarea1.adapter.MascotaAdaptador;
import com.example.administrador.curso4_tarea1.adapter.PerfilAdaptador;
import com.example.administrador.curso4_tarea1.pojo.Mascota;
import java.util.ArrayList;

/**
 * Created by administrador on 25/06/17.
 */

public interface IPerfilFragmentView {

    public void generarGridLayout();

    public PerfilAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(PerfilAdaptador adaptador);
}
