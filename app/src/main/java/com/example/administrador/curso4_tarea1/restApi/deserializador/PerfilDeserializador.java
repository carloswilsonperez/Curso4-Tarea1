package com.example.administrador.curso4_tarea1.restApi.deserializador;

import android.util.Log;

import com.example.administrador.curso4_tarea1.pojo.Perfil;
import com.example.administrador.curso4_tarea1.restApi.model.JsonKeys;
import com.example.administrador.curso4_tarea1.restApi.model.PerfilResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by administrador on 02/07/17.
 */

public class PerfilDeserializador {

    private static final String TAG = "PerfilDeserializador";

    @Override
    public PerfilResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PerfilResponse perfilResponse = gson.fromJson(json, PerfilResponse.class);//
        JsonArray perfilResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONCE_ARRAY);//Obtengo el array data del json
        perfilResponse.setPerfil(deserealizarPerfilDeJson(perfilResponseData));//llama al metodo contiguo para deserializar
        return perfilResponse; // Devuelve un objteto con de tipo response con la respuesta
    }



    public ArrayList<Perfil> deserealizarPerfilDeJson(JsonArray perfilResponseData){

        ArrayList<Perfil> perfils = new ArrayList<>();

        for (int i = 0; i < perfilResponseData.size(); i++) {
            JsonObject mascotaResponseDataObject = (JsonObject) perfilResponseData.get(i).getAsJsonObject();//Obtiene un elemento objeto del array
            JsonObject usuarioJson = perfilResponseData.getAsJsonObject(JsonKeys.USER); //obtiene el objeto usuarioApi
            String id = usuarioJson.get(JsonKeys.USER_ID).getAsString(); //obtiene el id del usuarioApi
            Log.d(TAG, "el valor del id es-> " + id);
            String nombreCompleto = usuarioJson.get(JsonKeys.USER_FULLNAME).getAsString(); //obtiene el nombre

            JsonObject imageJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);// otiene el objeto imagen del json
            JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION); // obtiene el objeto resolucion que dentro de imgen
            String urlFoto = stdResolutionJson.get(JsonKeys.MEDIA_URL).toString(); //Obtiene la url de la foto

            JsonObject likesJson = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES); //Obtiene el objeto likes
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt(); //Obtiene el numero de likes
            // Lleno los datos del usuarioApi actual
            Perfil perfilActual = new Perfil();
            perfilActual.setIdUsuario(id);
            perfilActual.setNombreCompleto(nombreCompleto);
            perfilActual.setUrlFotoPerfil(urlFoto);
            perfilActual.setNombreUsuario();

            perfils.add(perfilActual); //Guardo al perfil actual en el array perfiles
        }

        return perfils;
    }

}
