package com.example.administrador.curso4_tarea1.restApi;

/**
 * Created by administrador on 19/06/17.
 */

public final class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "5557323253.5477f1a.a6c8d1cf0f9747fe91b9c884bc63fcc4";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";

    // ************  SharedPrecerences  **************
    public static final String MI_SHARED_PREFERENCES = "MisDatos"; // nombre del SharedPreferences
    public static final String MI_USUARIO_SANDBOX = "supermascota5"; // nombe del usuario por default
    public static final String MI_ID_USUARIO_SANDBOX = "5557323253"; // id del usuario por default
    public static final String key_USUARIO_API = "usuario_api"; // llave para el nombre del xml
    public static final String key_ID_USUARIO_API = "id_usuario_api"; // llave para el nombre del xml



    // Petición para traer todas las imágenes de mi usuarioApi
    // https://api.instagram.com/v1/users/self/media/recent/?access_token=5557323253.5477f1a.a6c8d1cf0f9747fe91b9c884bc63fcc4
    public static final String URL_GET_RECENT_MEDIA_USER = ROOT_URL + KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    /* GET PARA BUSCAR LOS USUARIOS POR NOMBRE, a partir de ahi podemos obtener el id y luego hacer mas consultas
    https://api.instagram.com/v1/users/search?q=jarrieta31&access_token=5557323253.5477f1a.a6c8d1cf0f9747fe91b9c884bc63fcc4   */



    /* Trae todas las imagenes el usuarioApi que pasemos el id 5623708812
    https://api.instagram.com/v1/users/5623708812/media/recent/?access_token=5557323253.5477f1a.a6c8d1cf0f9747fe91b9c884bc63fcc4
     */

}
