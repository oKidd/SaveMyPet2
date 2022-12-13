package com.savemypet.savemypet2.Controller;

import com.savemypet.savemypet2.clases.Especie;

import java.util.ArrayList;

public class EspecieController {
    private static ArrayList<Especie> listaEspecie = new ArrayList<>();


    //CREATE --ADD
    public static String addEspecie(String id, String especie, int minTemp, int maxTemp, int minHumedad, int maxHumedad, int hluz){

        try {
            Especie e = new Especie(id, especie, minTemp, maxTemp, minHumedad, maxHumedad,hluz);
            listaEspecie.add(e);
            return "Especie Agregada";
        }catch(Exception e){
            return "Error: " + e.getMessage();
        }
    }


    //READ --FIND ALL
    public static ArrayList<Especie> findAll(){ return listaEspecie; }


    //READ --FIND
    public static Especie findEspecie(String especie){

        for (Especie e: listaEspecie) {
            if(e.getEspecie().equalsIgnoreCase(especie)){
                return e;
            }
        }
        return null;
    }

    public static void fillEspecie(){
        if(listaEspecie.size() <1) {
            addEspecie("1","Hurones", 15, 21, 45,55,14);
            addEspecie("2","Chinchillas", 15, 25, 40,65,12);
            addEspecie("3","Guacamayas", 16, 30, 0,80,11);
            addEspecie("4","Loros", 22, 24, 50,60,13);

            addEspecie("5","Canarios", 27, 32, 40,70,13);
            addEspecie("6","Tucanes", 10, 35, 60,85,12);
            addEspecie("7","Iguanas", 20, 25, 65,75,12);
            addEspecie("8","Serpiente", 22, 30, 60,90,12);

            addEspecie("9","Tortuga", 25, 35, 40,50,11);
            addEspecie("10","Conejos enanos", 16, 21, 60,70,7);
            addEspecie("11","Erizos de tierra", 24, 30, 0,40,12);
            addEspecie("12","Camaleones", 25, 100, 70,80,12);

        }
    }

}
