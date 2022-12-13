package com.savemypet.savemypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class PerfilUsuario extends AppCompatActivity {
    FirebaseAuth fbAuth;
    TextView tvusername, tvFono, tvEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        tvusername = findViewById(R.id.profile_name);
        tvFono = findViewById(R.id.profile_phone);
        tvEmail = findViewById(R.id.profile_email2);
       // FirebaseUser user = fbAuth.getCurrentUser();
       // tvEmail.setText(user.getEmail());
        //tvFono.setText(user.g);
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
}