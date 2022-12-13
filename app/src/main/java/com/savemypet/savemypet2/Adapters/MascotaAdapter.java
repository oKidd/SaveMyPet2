package com.savemypet.savemypet2.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.savemypet.savemypet2.Controller.MascotaController;
import com.savemypet.savemypet2.R;
import com.savemypet.savemypet2.clases.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends ArrayAdapter<Mascota> {
    androidx.appcompat.app.AppCompatActivity AppCompatActivity;

    public MascotaAdapter(AppCompatActivity context, int simple_list_item_1, ArrayList<Mascota> listaMascota) {
        super(context, R.layout.layout_mascota_item, MascotaController.findAll());
        AppCompatActivity = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String nombre = MascotaController.findAll().get(position).getNombre();
        LayoutInflater inflater = AppCompatActivity.getLayoutInflater();
        View item = inflater.inflate(R.layout.layout_mascota_item,null);

        TextView tvNombreMascota = item.findViewById(R.id.tvNombreMascota);

        tvNombreMascota.setText(nombre);



        return super.getView(position, convertView, parent);
    }
}



