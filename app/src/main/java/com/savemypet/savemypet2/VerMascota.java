package com.savemypet.savemypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.savemypet.savemypet2.Controller.EspecieController;
import com.savemypet.savemypet2.clases.Especie;

public class VerMascota extends AppCompatActivity {
    String nombre;
    String estado, especie;
    Especie esp;
    int numMascotas;
    TextView nombreMascota, temperaturaMascota, humedadMascota, estadoM, especieM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vermascota);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refTemperatura = database.getReference("temperatura");
        DatabaseReference refHumedad = database.getReference("humedad");
        nombreMascota = findViewById(R.id.nombreMascota);
        temperaturaMascota = findViewById(R.id.pet_temptext);
        humedadMascota = findViewById(R.id.pet_humtext);
        estadoM = findViewById(R.id.pet_estadotext) ;
        especieM = findViewById(R.id.pet_especie);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            nombre = bundle.getString("nombre");
            estado = bundle.getString("estado");
            numMascotas  = bundle.getInt("numMascotas");
            especie = bundle.getString("especie");

            nombreMascota.setText(nombre.toString());
            estadoM.setText(estado);
            especieM.setText(especie);

            esp = EspecieController.findEspecie(especie);

            //Cambiar temperatura
            refTemperatura.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshotT) {
                    String temp = dataSnapshotT.getValue().toString();
                    temperaturaMascota.setText(temp+" C°");
                    if (Integer.valueOf(temp) < esp.getMinTemperatura() || Integer.valueOf(temp) > esp.getMaxTemperatura()){
                        temperaturaMascota.setTextColor(Color.RED);
                    } else {
                        temperaturaMascota.setTextColor(Color.GREEN);
                    }
                }
                @Override
                public void onCancelled(DatabaseError errorT) {
                    // Failed to read value
                    Log.w("TAG", "Failed to read value.", errorT.toException());
                }
            });


            //CAmbiar Humedad

            refHumedad.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshotH) {
                    String humedad = dataSnapshotH.getValue().toString();
                    humedadMascota.setText(humedad+" %");
                    if (Integer.valueOf(humedad) < esp.getMinHumedad() || Integer.valueOf(humedad) > esp.getMaxHumedad()){
                        humedadMascota.setTextColor(Color.RED);
                    } else {
                        humedadMascota.setTextColor(Color.GREEN);
                    }
                }
                @Override
                public void onCancelled(DatabaseError errorH) {
                    Log.w("TAG", "Failed to read value.", errorH.toException());
                }
            });
        }
    }

    public void irAHome(View v){
        finish();
        Intent ihome = new Intent(VerMascota.this, Home.class);
        startActivity(ihome);
    }
    public void irAPerfil(View v){
        finish();
        Intent iperfil = new Intent(VerMascota.this, PerfilUsuario.class);
        iperfil.putExtra("numMascotas", numMascotas);
        startActivity(iperfil);
    }

    public void editarMascota(View v){
        Intent iEditarMascota = new Intent(VerMascota.this, EditarMascota.class);
        startActivity(iEditarMascota);
    }

    public void addMascota(View v){
        Intent iadd = new Intent(VerMascota.this, AgregarMascota.class);
        startActivity(iadd);
    }
}