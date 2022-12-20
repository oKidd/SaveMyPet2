package com.savemypet.savemypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VerMascota extends AppCompatActivity {
    String nombre;
    String estado;
    TextView nombreMascota, temperaturaMascota, humedadMascota, estadoM;
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

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            nombre = bundle.getString("nombre");
            estado = bundle.getString("estado");

            nombreMascota.setText(nombre.toString());
            estadoM.setText(estado);

            //Cambiar temperatura

            refTemperatura.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshotT) {
                    String temp = dataSnapshotT.getValue().toString();
                    temperaturaMascota.setText(temp+" C°");
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