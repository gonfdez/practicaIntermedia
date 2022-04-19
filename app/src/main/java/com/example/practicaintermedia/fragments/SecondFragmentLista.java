package com.example.practicaintermedia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practicaintermedia.R;
import com.example.practicaintermedia.utils.Marca;
import java.util.ArrayList;

public class SecondFragmentLista extends Fragment {

    private View view;
    private ListView listaCoches;
    private ArrayAdapter<Coche> adaptadorCoches;
    private ArrayList<Coche> arrayCoches;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lista,container,
                false);
        // hago las instancias aqui
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        listaCoches = view.findViewById(R.id.listaMarcas_fragment);
        listaCoches.setAdapter(adaptadorCoches);
    }

    class AdaptadorCoches extends ArrayAdapter<Coche> {

        AppCompatActivity appCompatActivity;
        AdaptadorCoches(AppCompatActivity context) {
            super(context, R.layout.list_item_coche, arrayCoches);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_marca, null);
            TextView txtMarca = item.findViewById(R.id.txtMarca);
            txtMarca.setText(arrayCoches.get(position).getNombre());
                ImageView imgCoche = item.findViewById(R.id.imgCoche);
            imgCoche.setImageResource(arrayCoches.get(position).getImg());
            return(item);
        }
    }

}