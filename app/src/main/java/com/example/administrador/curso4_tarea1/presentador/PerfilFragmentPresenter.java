package com.example.administrador.curso4_tarea1.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.administrador.curso4_tarea1.pojo.Mascota;
import com.example.administrador.curso4_tarea1.restApi.EndpointsApi;
import com.example.administrador.curso4_tarea1.restApi.adapter.RestApiAdapter;
import com.example.administrador.curso4_tarea1.restApi.model.MascotaResponse;
import com.example.administrador.curso4_tarea1.vista_fragment.IPerfilFragmentView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by administrador on 25/06/17.
 */

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter{

    private static final String TAG = "Fallo de conexion";
    private Context context;
    private IPerfilFragmentView iPerfilFragmentView;
    private ArrayList<Mascota> mascotas;

    //El contructor recibe un instacia del la Iterface de la vista y el contexto
    public PerfilFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.context = context;
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent(); //primero el adaptador construye el Gson y luego lo recibe el metodo establecerConexionRestApiInstagram
        //Creo un objeto EndpointsApi utilizando la instancia del RestApiAdapter y el metodo establecerConexionRestApiInstagram()
        // el cual devuelve un objeto de tipo EndpointsApi ya con la url-base cargada y esperando una petición a ejecutar
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();  // El metodo getRecentMedia realiza la petición y lo guarda en el objeto Call de la clase Retrofit
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() { //Metodo para controlar el resultado de la respuesta, si trae datos o no
            @Override // Si la conexión es exitosa:
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body(); //obtiene solo la data del objeto json recibido
                mascotas = mascotaResponse.getMascotas();// guarda el ArrayList de mascotas
                mostrarMediosRecientesRv();
            }
            @Override // Si la conexión falla:
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();//Mensaje para el usuarioApi
                // log para el programador
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public void mostrarMediosRecientesRv() {
        // Hay que inicializar el adaptador, para ello primero se debe crear el adaptador y pasarele el ArrayList mascotas
        iPerfilFragmentView.inicializarAdaptadorRV(iPerfilFragmentView.crearAdaptador(mascotas));
        iPerfilFragmentView.generarGridLayout();// Luego se debe indicar que genere el GridLayout
    }

    @Override
    public void obtenerPerfil() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent(); //primero el adaptador construye el Gson y luego lo recibe el metodo establecerConexionRestApiInstagram
        //Creo un objeto EndpointsApi utilizando la instancia del RestApiAdapter y el metodo establecerConexionRestApiInstagram()
        // el cual devuelve un objeto de tipo EndpointsApi ya con la url-base cargada y esperando una petición a ejecutar
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endpointsApi.getRecentMedia();  // El metodo getRecentMedia realiza la petición y lo guarda en el objeto Call de la clase Retrofit
        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() { //Metodo para controlar el resultado de la respuesta, si trae datos o no
            @Override // Si la conexión es exitosa:
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body(); //obtiene solo la data del objeto json recibido
                mascotas = mascotaResponse.getMascotas();// guarda el ArrayList de mascotas
                mostrarMediosRecientesRv();
            }
            @Override // Si la conexión falla:
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();//Mensaje para el usuarioApi
                // log para el programador
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public void mostrarPerfil() {

    }
}
