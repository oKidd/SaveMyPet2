package com.savemypet.savemypet2.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.savemypet.savemypet2.Controller.MascotaController;
import com.savemypet.savemypet2.R;
import com.savemypet.savemypet2.clases.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends ArrayAdapter<Mascota> {

    public MascotaAdapter(Context context, ArrayList<Mascota> listaMascota) {
        super(context, 0, listaMascota);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView = convertView;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference refTemperatura = database.getReference("temperatura");
        DatabaseReference refHumedad = database.getReference("humedad");

        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.layout_mascota_item, parent, false);
        }
        Mascota mascota = getItem(position);
        TextView tvNombreMascota = listitemView.findViewById(R.id.tvNombreMascota);
        TextView tvTemperatura = listitemView.findViewById(R.id.tvTemperaturaItem);
        TextView tvHumedad = listitemView.findViewById(R.id.tvHumedadItem);

        tvNombreMascota.setText(mascota.getNombre());

        //Cambiar temperatura

        refTemperatura.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshotT) {
                String temp = dataSnapshotT.getValue().toString();
                tvTemperatura.setText(temp+" C°");
                if (Integer.valueOf(temp) < mascota.getEspecie().getMinTemperatura() || Integer.valueOf(temp) > mascota.getEspecie().getMaxTemperatura()){
                    tvTemperatura.setTextColor(Color.RED);
                } else {
                    tvTemperatura.setTextColor(Color.GREEN);
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
                tvHumedad.setText(humedad+" %");
                if (Integer.valueOf(humedad) < mascota.getEspecie().getMinHumedad() || Integer.valueOf(humedad) > mascota.getEspecie().getMaxHumedad()){
                    tvTemperatura.setTextColor(Color.RED);
                } else {
                    tvTemperatura.setTextColor(Color.GREEN);
                }
            }
            @Override
            public void onCancelled(DatabaseError errorH) {
                Log.w("TAG", "Failed to read value.", errorH.toException());
            }
        });

        return listitemView;
    }
}



