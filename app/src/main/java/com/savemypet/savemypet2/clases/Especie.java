package com.savemypet.savemypet2.clases;

public class Especie {
    String id;
    String especie;
    int minTemperatura;
    int maxTemperatura;
    int minHumedad;
    int maxHumedad;
    int horasLuz;

    public Especie(){}

    public Especie(String id, String especie, int minTemperatura, int maxTemperatura, int minHumedad, int maxHumedad, int horasLuz) {
        this.id = id;
        this.especie = especie;
        this.minTemperatura = minTemperatura;
        this.maxTemperatura = maxTemperatura;
        this.minHumedad = minHumedad;
        this.maxHumedad = maxHumedad;
        this.horasLuz = horasLuz;
    }

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

    public int getMinTemperatura() {
        return minTemperatura;
    }

    public void setMinTemperatura(int minTemperatura) {
        this.minTemperatura = minTemperatura;
    }

    public int getMaxTemperatura() {
        return maxTemperatura;
    }

    public void setMaxTemperatura(int maxTemperatura) {
        this.maxTemperatura = maxTemperatura;
    }

    public int getMinHumedad() {
        return minHumedad;
    }

    public void setMinHumedad(int minHumedad) {
        this.minHumedad = minHumedad;
    }

    public int getMaxHumedad() {
        return maxHumedad;
    }

    public void setMaxHumedad(int maxHumedad) {
        this.maxHumedad = maxHumedad;
    }

    public int getHorasLuz() {
        return horasLuz;
    }

    public void setHorasLuz(int horasLuz) {
        this.horasLuz = horasLuz;
    }
}
