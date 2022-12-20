package com.savemypet.savemypet2.Controller;

import com.savemypet.savemypet2.clases.Especie;
import com.savemypet.savemypet2.clases.Mascota;
import com.savemypet.savemypet2.clases.Usuario;

import java.util.ArrayList;

public class MascotaController {
    private static ArrayList<Mascota> listaMascotas = new ArrayList<>();


    //CREATE --ADD
    public static String addAlumno(String id, String nombre, Especie especie, String idusuario){

        try {
            Mascota m = new Mascota(id, nombre, especie, idusuario);
            listaMascotas.add(m);
            return "Mascota Agregado";
        }catch(Exception e){
            return "Error: " + e.getMessage();
        }
    }


    //READ --FIND ALL
    public static ArrayList<Mascota> findAll(){ return listaMascotas; }


    //READ --FIND
    public static Mascota findMascota(String id){

        for (Mascota m: listaMascotas) {
            if(m.getId().equalsIgnoreCase(id)){
                return m;
            }
        }
        return null;
    }


}

