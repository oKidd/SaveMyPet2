package com.savemypet.savemypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditarUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);
    }

    public void iraPerfil(View v){
        finish();
        Intent iPerfil = new Intent(EditarUsuario.this, PerfilUsuario.class);
        startActivity(iPerfil);
    }


}