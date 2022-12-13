package com.savemypet.savemypet2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            nombre = bundle.getString("nombre");
            temp = bundle.getInt("temp");
            humedad = bundle.getInt("humedad");
            estado = bundle.getString("estado");

            nombreMascota.setText(nombre);
            temperaturaMascota.setText(String.valueOf(temp));
            humedadMascota.setText(String.valueOf(humedad));
            estadoM.setText(String.valueOf(estado));
        }
    }
}