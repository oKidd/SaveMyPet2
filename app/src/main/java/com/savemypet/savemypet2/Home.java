package com.savemypet.savemypet2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.savemypet.savemypet2.Adapters.MascotaAdapter;
import com.savemypet.savemypet2.Controller.EspecieController;
import com.savemypet.savemypet2.clases.Especie;
import com.savemypet.savemypet2.clases.Mascota;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private ArrayList<Mascota> listaMascota;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    MascotaAdapter adapter;

    Mascota mascotaSeleccionada;

    private ListView lvHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        lvHome = findViewById(R.id.home_lista);
        listaMascota = new ArrayList<>();
        iniciarFirebase();
        listarMascotas();
    }

    private void listarMascotas() {


        databaseReference.child("Mascota").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaMascota.clear();

                for (DataSnapshot item : snapshot.getChildren()) {

                    Mascota a = item.getValue(Mascota.class);
                    listaMascota.add(a);
                }
                MascotaAdapter adapter = new MascotaAdapter(Home.this, listaMascota);
                lvHome.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void iniciarFirebase() {
        FirebaseApp.initializeApp(Home.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void addMascota(View v){
        finish();
        Intent iAddM = new Intent(Home.this, AgregarMascota.class);
        startActivity(iAddM);
    }
}