package com.example.administrador.curso4_tarea1.vista_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrador.curso4_tarea1.R;
import com.example.administrador.curso4_tarea1.adapter.MascotaAdaptador;
import com.example.administrador.curso4_tarea1.adapter.PerfilAdaptador;
import com.example.administrador.curso4_tarea1.pojo.Mascota;
import com.example.administrador.curso4_tarea1.pojo.Perfil;
import com.example.administrador.curso4_tarea1.presentador.IPerfilFragmentPresenter;
import com.example.administrador.curso4_tarea1.presentador.PerfilFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragmentView extends Fragment implements IPerfilFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvPerfiles;
    private IPerfilFragmentPresenter presenter;
    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKE = "like";

    // Primero hay que sobreescribir el método onCreateView
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil , container, false);
        rvPerfiles = (RecyclerView) v.findViewById(R.id.rvPerfil);
        presenter = new PerfilFragmentPresenter(this, getContext());
        return v;
    }


    // Cargo las mascotas a mostrar
    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

     /*   mascotas.add(new Mascota("Yaman", 2, getResources().getString(R.drawable.perro01), R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 5, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 3, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 3, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 4, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 2, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 2, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 2, R.drawable.perro01, R.color.fondo_perro01));
        mascotas.add(new Mascota("Yaman", 5, R.drawable.perro01, R.color.fondo_perro01));*/
    }


    @Override // Crea el GridLayout para presentar los perfiles
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        rvPerfiles.setLayoutManager(glm);//Le decimos que el RecyclerView se comporte como un GridLayoutManager
    }

    @Override // Genera el adaptador que va a manejar el RecylerView, en este caso es el PerfilAdaptador y recibie un ArrayList de mascotas
    public PerfilAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override // Le indicamos al RecyclerView el adaptador que debe usar
    public void inicializarAdaptadorRV(PerfilAdaptador adaptador) {
        rvPerfiles.setAdapter(adaptador);
    }

    @Override
    public void mostrarPerfil(Perfil perfils) {

    }
}
