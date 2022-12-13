package com.savemypet.savemypet2.clases;

public class Especie {
    String id;
    String especie;
    int temperatura;
    int humedad;
    String luz;

    public Especie(String id, String especie, int temperatura, int humedad, String luz) {
        this.id = id;
        this.especie = especie;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.luz = luz;
    }

    public Especie(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public String getLuz() {
        return luz;
    }

    public void setLuz(String luz) {
        this.luz = luz;
    }
}
