package com.example.practicaintermedia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practicaintermedia.R;
import com.example.practicaintermedia.utils.Coche;
import com.example.practicaintermedia.utils.Marca;
import java.util.ArrayList;

public class SecondFragmentLista extends Fragment {

    private View view;
    private ListView listaCoches;
    private ArrayAdapter<Coche> adaptadorCoches;
    private ArrayList<Coche> arrayCoches, listaFiltrada;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        arrayCoches= new ArrayList();
        listaFiltrada = new ArrayList<>();

        arrayCoches.add(new Coche("BMW", "x1", 0, 0, 0));
        arrayCoches.add(new Coche("Tesla", "x1", 0, 0, 0));
        arrayCoches.add(new Coche("Mercedes Benz", "x1", 0, 0, 0));
        arrayCoches.add(new Coche("Ferrari", "x1", 0, 0, 0));

        adaptadorCoches = new SecondFragmentLista.AdaptadorCoches((AppCompatActivity) context, arrayCoches, listaFiltrada);
    }

    // Metodo para recibir el dato segun el cual filtrar la informacion a enseñar
    public void comunicarDato(String marca){
        Log.v("comunicacion", marca);

        // Modifica la lista para enseñar solo los coches de esa marca
        for ( Coche item : arrayCoches ) {
            if (item.getMarca().equalsIgnoreCase(marca)){
                listaFiltrada.add(item);
            }
        }
        adaptadorCoches.notifyDataSetChanged();
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
        ArrayList<Coche> dataList, filtList;

        AdaptadorCoches(AppCompatActivity context, ArrayList<Coche> arrayInicial, ArrayList<Coche> arrayFiltrado ) {
            super(context, R.layout.list_item_coche, arrayInicial);
            appCompatActivity = context;
            dataList = arrayInicial;
            filtList = arrayFiltrado;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_coche, null);

            // Imagen del modelo
            //ImageView imgCoche = item.findViewById(R.id.imgCoche);
            //imgCoche.setImageResource(arrayCoches.get(position).getImg());

            //Texto del modelo
            TextView txtCoche = item.findViewById(R.id.txtCoche);
            txtCoche.setText(arrayCoches.get(position).getModelo());



            return(item);
        }

        @Override
        public void notifyDataSetChanged() {
            dataList = this.filtList;
            super.notifyDataSetChanged();

        }
    }

}