package com.example.administrador.curso4_tarea1.restApi.adapter;

import com.example.administrador.curso4_tarea1.restApi.ConstantesRestApi;
import com.example.administrador.curso4_tarea1.restApi.EndpointsApi;
import com.example.administrador.curso4_tarea1.restApi.deserializador.MascotaDeserializador;
import com.example.administrador.curso4_tarea1.restApi.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by administrador on 19/06/17.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)) // deserializacion automatica de los datos espesificos que le indica el Gson
                .build();
        return retrofit.create(EndpointsApi.class);
    }

    //Creo un metodo porque la clase contacto debe coincidir con contactoDesearializador
    // Por cada tipo de consulta a la api hay que hacer un metodo deserializador para ese tipo de llamada
    public Gson construyeGsonDeserializadorMediaRecent(){
        //objeto que sirve para que lo que se desearialize se lo asocie con el objeto Mascota
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador()); // define la asociación
        return  gsonBuilder.create();  // retorna el Gson con la asociacion creada
    }
}
