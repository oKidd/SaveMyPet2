package com.savemypet.savemypet2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    FirebaseAuth fbAuth;
    FirebaseUser userAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Mascota mascotaSeleccionada;

    private ListView lvHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        lvHome = findViewById(R.id.home_lista);
        fbAuth = FirebaseAuth.getInstance();
        userAuth = fbAuth.getCurrentUser();
        listaMascota = new ArrayList<>();
        iniciarFirebase();
        listarMascotas();

        lvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Home.this, VerMascota.class);
                mascotaSeleccionada = (Mascota) adapterView.getItemAtPosition(i);

                intent.putExtra("nombre", mascotaSeleccionada.getNombre());
                intent.putExtra("estado", "Despierto");
                intent.putExtra("numMascotas", listaMascota.size());

                startActivity(intent);
            }
        });
    }

    private void listarMascotas() {
        databaseReference.child("Mascotas").orderByChild("idUsuario").equalTo(userAuth.getUid()).addValueEventListener(new ValueEventListener() {
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
        iAddM.putExtra("numMascotas", listaMascota.size());
        startActivity(iAddM);
    }

    public void cerrarSesion(View v){
        FirebaseUser user = fbAuth.getCurrentUser();
        if (user != null) {
            fbAuth.signOut();
            finish();
            Intent imain = new Intent(Home.this, MainActivity.class);
            startActivity(imain);
            Toast.makeText(this, "Sesion Finalizada", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Debe iniciar sesion", Toast.LENGTH_SHORT).show();
        }
    }

    public void irAPerfil(View v){
        Intent iPerfil = new Intent(Home.this, PerfilUsuario.class);
        iPerfil.putExtra("numMascotas", listaMascota.size());
        startActivity(iPerfil);
    }

    public void irANotificaciones(View v){
        Toast.makeText(this, "Proximamente", Toast.LENGTH_LONG).show();
    }

    public void irAConfiguraciones(View v){
        Toast.makeText(this, "Proximamente", Toast.LENGTH_LONG).show();
    }
}