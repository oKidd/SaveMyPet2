package com.savemypet.savemypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VerMascota extends AppCompatActivity {
    String nombre;
    int temp, humedad;
    String estado;
    TextView nombreMascota, temperaturaMascota, humedadMascota, estadoM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vermascota);
        nombreMascota = findViewById(R.id.nombreMascota);
        temperaturaMascota = findViewById(R.id.pet_temptext);
        humedadMascota = findViewById(R.id.pet_humtext);
        estadoM = findViewById(R.id.pet_estadotext) ;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            nombre = bundle.getString("nombre");
            temp = bundle.getInt("temp");
            humedad = bundle.getInt("humedad");
            estado = bundle.getString("estado");

            nombreMascota.setText(nombre.toString());
            temperaturaMascota.setText(String.valueOf(temp)+ "C°");
            humedadMascota.setText(String.valueOf(humedad)+" %");
            estadoM.setText(estado);
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