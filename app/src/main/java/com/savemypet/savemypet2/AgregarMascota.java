package com.savemypet.savemypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.savemypet.savemypet2.Controller.EspecieController;
import com.savemypet.savemypet2.clases.Especie;
import com.savemypet.savemypet2.clases.Mascota;

import java.util.UUID;

public class AgregarMascota extends AppCompatActivity {
    Spinner spnEspecie;
    EditText etAddNombre;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_mascota);
        spnEspecie = findViewById(R.id.addpet_especie);
        etAddNombre = findViewById(R.id.addpet_name);
        iniciarFirebase();
        EspecieController.fillEspecie();
        String[] especie = {"Hurones", "Chinchillas","Guacamayas","Loros", "Canarios","Tucanes", "Iguanas","Serpiente","Tortuga","Conejos enanos", "Erizos de tierra","Camaleones"};
        ArrayAdapter<String> adapterE = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, especie);
        spnEspecie.setAdapter(adapterE);

    }

    private void iniciarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    public void addMascota(View v){
        String id = UUID.randomUUID().toString();
        String nombre = etAddNombre.getText().toString();
        String especie = spnEspecie.getSelectedItem().toString();
        Especie es = null;

        switch (especie){
            case "Hurones":
                es = EspecieController.findEspecie("Hurones");
                break;
            case "Chinchillas":
                es = EspecieController.findEspecie("Chinchillas");
                break;
            case "Guacamayas":
                es  = EspecieController.findEspecie("Guacamayas");
                break;
            case "Loros":
                es = EspecieController.findEspecie("Loros");
                break;
            case "Canarios":
                es = EspecieController.findEspecie("Canarios");
                break;
            case "Tucanes":
                es  = EspecieController.findEspecie("Tucanes");
                break;
            case "Iguanas":
                es = EspecieController.findEspecie("Iguanas");
                break;
            case "Serpiente":
                es  = EspecieController.findEspecie("Serpiente");
                break;
            case "Tortuga":
                es = EspecieController.findEspecie("Tortuga");
                break;
            case "Conejos enanos":
                es = EspecieController.findEspecie("Conejos enanos");
                break;
            case "Erizos de tierra":
                es = EspecieController.findEspecie("Erizos de tierra");
                break;
            case "Camaleones":
                es = EspecieController.findEspecie("Camaleones");
                break;
        }

        if (!nombre.isEmpty()){
            Mascota pet = new Mascota();
            pet.setId(id);
            pet.setNombre(nombre);
            pet.setEspecie(es);

            databaseReference.child("Mascota").child(pet.getId()).setValue(pet);
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show();
            finish();
            Intent iHome = new Intent(AgregarMascota.this, Home.class);
            startActivity(iHome);
        }



    }

    public void irAHome(View v){
        finish();
        Intent iHome = new Intent(AgregarMascota.this, Home.class);
        startActivity(iHome);


    }

    public void irAPerfil(View v){
        Intent iPerfil = new Intent(AgregarMascota.this, PerfilUsuario.class);
        startActivity(iPerfil);
    }
}