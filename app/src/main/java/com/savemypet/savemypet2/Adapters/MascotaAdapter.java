package com.savemypet.savemypet2.Adapters;

import android.content.Context;
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

    public MascotaAdapter(Context context, ArrayList<Mascota> listaMascota) {
        super(context, 0, listaMascota);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.layout_mascota_item, parent, false);
        }
        Mascota mascota = getItem(position);
        TextView tvNombreMascota = listitemView.findViewById(R.id.tvNombreMascota);
        tvNombreMascota.setText(mascota.getNombre());
        /*
        String nombre = MascotaController.findAll().get(position).getNombre();

        LayoutInflater inflater = AppCompatActivity.getLayoutInflater();
        View item = inflater.inflate(R.layout.layout_mascota_item,null);

        TextView tvNombreMascota = item.findViewById(R.id.tvNombreMascota);



*/

        return listitemView;
    }
}



