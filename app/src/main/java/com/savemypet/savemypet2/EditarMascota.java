package com.savemypet.savemypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditarMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_mascota);
    }
    public void irAMascota(View v){
        finish();
        Intent iMascota = new Intent(EditarMascota.this, VerMascota.class);
        startActivity(iMascota);
    }
}