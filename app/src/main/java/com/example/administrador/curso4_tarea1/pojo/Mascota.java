package com.example.administrador.curso4_tarea1.pojo;

/**
 * Created by administrador on 08/05/17.
 */

public class Mascota {

    private int id;
    private String nombre;
    private int numLinkes;
    private int foto;
    private int colorFondo;


    //Contructor
    public Mascota (String nombre, int numLinkes, int foto, int colorFondo){
        this.nombre = nombre;
        this.numLinkes = numLinkes;
        this.foto = foto;
        this.colorFondo = colorFondo;
    }

    public Mascota(){

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumLinkes() {
        return numLinkes;
    }

    public void setNumLinkes(int numLinkes) {
        this.numLinkes = numLinkes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(int colorFondo) {
        this.colorFondo = colorFondo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
