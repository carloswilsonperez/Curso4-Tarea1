package com.example.administrador.curso4_tarea1.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrador.curso4_tarea1.R;

/**
 * Created by administrador on 18/06/17.
 */

public class ConfiguraCuentaActivity extends AppCompatActivity {

    EditText etNombreSandbox;
    Button btnGuardarCuenta;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracuenta);

        etNombreSandbox = (EditText) findViewById(R.id.etNombreSandbox);
        btnGuardarCuenta = (Button) findViewById(R.id.btnGuardarCuenta);
        toolbar     = (Toolbar)findViewById(R.id.toolbar);

        if (toolbar!=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Oculta el titulo del ToolBar
        }


        // Al presionar el botón "Guardar Cuenta"
        btnGuardarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreSandbox = etNombreSandbox.getText().toString(); //obtengo el contenido del EditText

                if(nombreSandbox != null && !nombreSandbox.isEmpty()){
                    // creo un objeto MisDatos.xml para la presistencia de las preferencias guardadas
                    SharedPreferences miPreferecia = getSharedPreferences("MisDatos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = miPreferecia.edit(); //Creo el editor para manejar el archivo MisDatos.xml
                    editor.putString("nombreSandbox", nombreSandbox); //Seteo el valor a guardar en el xml
                    editor.commit(); //guarda el nombre del usuario sandbox utilizado para api de instagram
                    String nombre= miPreferecia.getString("nombreSandbox", "");
                    Toast.makeText(ConfiguraCuentaActivity.this, "La cuenta de usuario \'"+ nombre+ "\' ha sido guardada.", Toast.LENGTH_LONG).show();
                    etNombreSandbox.setText("");

                }else {

                    Toast.makeText(ConfiguraCuentaActivity.this, "No hay ningún nombre para guardar", Toast.LENGTH_LONG).show();
                }
            }
        });




    }
}
