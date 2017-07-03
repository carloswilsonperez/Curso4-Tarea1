package com.example.administrador.curso4_tarea1.restApi;

import com.example.administrador.curso4_tarea1.pojo.Mascota;
import com.example.administrador.curso4_tarea1.restApi.model.MascotaResponse;
import com.example.administrador.curso4_tarea1.restApi.model.PerfilResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by administrador on 19/06/17.
 */

// Interface que genera las peticiones a la api
public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)//Peticion GET a la api de instagram que va a ser usada por el metodo seguido
    Call<MascotaResponse> getRecentMedia(); //Retrofit necesita usar la clase Call

    @GET("https://api.instagram.com/v1/users/search?q=supermascota5&access_token=5557323253.5477f1a.a6c8d1cf0f9747fe91b9c884bc63fcc4") //
    Call<PerfilResponse> getPerfil();

}
