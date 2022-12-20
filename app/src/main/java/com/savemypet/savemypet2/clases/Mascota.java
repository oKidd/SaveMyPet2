package com.savemypet.savemypet2.clases;

public class Mascota {
    String id;
    String nombre;
    Especie especie;
    String idUsuario;

    public Mascota(){}

    public Mascota(String id, String nombre, Especie especie, String idUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.idUsuario = idUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
