package com.example.administrador.curso4_tarea1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.administrador.curso4_tarea1.R;
import com.example.administrador.curso4_tarea1.adapter.PageAdapter;
import com.example.administrador.curso4_tarea1.vista_fragment.HomeFragmentView;
import com.example.administrador.curso4_tarea1.vista_fragment.PerfilFragmentView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar     = (Toolbar)findViewById(R.id.toolbar);
        tabLayout   = (TabLayout)findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager(); //Activa los fragments

        if (toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Oculta el titulo del ToolBar
        }

        ImageView imgFavotitas = (ImageView)findViewById(R.id.imgFaboritas);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpViewPager(); //Activa los fragments
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.mContacto:
                Intent intent1 = new Intent(this, FormularioActivity.class);
                startActivity(intent1);
                break;

            case R.id.mAcercaDe:
                Intent intent2 = new Intent(this, AcercadeActivity.class);
                startActivity(intent2);
                break;
            case R.id.mConfigurarCuenta:
                Intent intent3 = new Intent(this, ConfiguraCuentaActivity.class);
                startActivity(intent3);

                break;
        }
        return super.onOptionsItemSelected(item);
    }


    // Abre el activity2 con las 5 mascotas favoritas
    public void irFavoritas(View view){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    // Método para cargar el ArrayList con los fragments existentes
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        // Cargo los fragments en el órden que los quiero mostrar
        fragments.add(new HomeFragmentView());
        fragments.add(new PerfilFragmentView());
        return  fragments;
    }

    // Método para poner en orvita los fragments
    private void setUpViewPager(){
        // Se inicializa el viewPager con una instancia de la clase PageAdapter, se le pasa el manejador de fragments y
        // por último se llama a la funcion agregarFragments que devuelve el ArrayList con los fragments.
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perro);
    }


}
