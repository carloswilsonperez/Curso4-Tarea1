package com.example.administrador.curso4_tarea1.restApi;

import com.example.administrador.curso4_tarea1.pojo.Mascota;
import com.example.administrador.curso4_tarea1.restApi.model.MascotaResponse;
import com.example.administrador.curso4_tarea1.restApi.model.PerfilResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by administrador on 19/06/17.
 */

// Interface que genera las peticiones a la api
public interface EndpointsApi {
    //https://api.instagram.com/v1/users/5623708812/media/recent/?access_token=5557323253.5477f1a.a6c8d1cf0f9747fe91b9c884bc63fcc4
    @GET("users/{id}")//Peticion GET a la api de instagram que va a ser usada por el metodo seguido
    Call<MascotaResponse> getRecentMedia(@Path("id") String id, @Query("access_token") String token); //Retrofit necesita usar la clase Call

    /* GET PARA BUSCAR LOS USUARIOS POR NOMBRE, a partir de ahi podemos obtener el id y luego hacer mas consultas
    https://api.instagram.com/v1/users/search?q=jarrieta31&access_token=5557323253.5477f1a.a6c8d1cf0f9747fe91b9c884bc63fcc4   */
    @GET("users/search") //
    Call<PerfilResponse> getPerfil(@Query("q") String nombre, @Query("access_token") String token);

}
