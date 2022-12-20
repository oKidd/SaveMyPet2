package com.savemypet.savemypet2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.savemypet.savemypet2.clases.Mascota;
import com.savemypet.savemypet2.clases.Usuario;

import java.util.ArrayList;

public class PerfilUsuario extends AppCompatActivity {
    int numMascotas;
    FirebaseAuth fbAuth;
    FirebaseUser userAuth;
    TextView tvusername, tvFono, tvEmail, tvnumMascotas;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refUsuario = database.getReference("user");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        tvusername = findViewById(R.id.profile_name);
        tvFono = findViewById(R.id.profile_phone);
        tvEmail = findViewById(R.id.profile_email2);
        tvnumMascotas = findViewById(R.id.profile_pets_number);
        fbAuth = FirebaseAuth.getInstance();
        userAuth = fbAuth.getCurrentUser();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            numMascotas = bundle.getInt("numMascotas");
        }
        refUsuario.child(userAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    tvusername.setText(snapshot.child("name").getValue().toString());
                    tvEmail.setText(snapshot.child("email").getValue().toString());
                    tvFono.setText(snapshot.child("fono").getValue().toString());
                    tvnumMascotas.setText(String.valueOf(numMascotas));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

   public void irAHome(View v){
        finish();
        Intent ihome = new Intent(PerfilUsuario.this, Home.class);
        startActivity(ihome);
   }

    public void addMascota(View v){
        finish();
        Intent iAddM = new Intent(PerfilUsuario.this, AgregarMascota.class);
        startActivity(iAddM);
    }

    public void modificarPerfil(View v){
        Intent iEditarPerfil = new Intent(PerfilUsuario.this, EditarUsuario.class);
        startActivity(iEditarPerfil);
    }
}