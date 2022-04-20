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
        arrayCoches= new ArrayList<Coche>();
        listaFiltrada = new ArrayList<Coche>();

        arrayCoches.add(new Coche("BMW", "x1", R.drawable.x1, 0, 0));
        arrayCoches.add(new Coche("BMW", "x2", R.drawable.x2, 0, 0));
        arrayCoches.add(new Coche("BMW", "x3", R.drawable.x3, 0, 0));

        arrayCoches.add(new Coche("Tesla", "Model 3", R.drawable.model3, 0, 0));
        arrayCoches.add(new Coche("Tesla", "Model Y", R.drawable.modely, 0, 0));
        arrayCoches.add(new Coche("Tesla", "Model S", R.drawable.models, 0, 0));
        arrayCoches.add(new Coche("Tesla", "Model X", R.drawable.modelx, 0, 0));
        arrayCoches.add(new Coche("Tesla", "Roadster", R.drawable.roadster, 0, 0));

        arrayCoches.add(new Coche("Mercedes Benz", "Clase A", R.drawable.clasea, 0, 0));
        arrayCoches.add(new Coche("Mercedes Benz", "Clase B", R.drawable.claseb, 0, 0));
        arrayCoches.add(new Coche("Mercedes Benz", "Clase C", R.drawable.clasec, 0, 0));
        arrayCoches.add(new Coche("Mercedes Benz", "Clase E", R.drawable.clasee, 0, 0));
        arrayCoches.add(new Coche("Mercedes Benz", "Clase G", R.drawable.claseg, 0, 0));
        
        arrayCoches.add(new Coche("Ferrari", "250 Testarosa", R.drawable.testarossa, 0, 0));
        arrayCoches.add(new Coche("Ferrari", "458 Spider", R.drawable.spider, 0, 0));
        arrayCoches.add(new Coche("Ferrari", "LaFerari", R.drawable.laferrari, 0, 0));
        arrayCoches.add(new Coche("Ferrari", "812 GTS", R.drawable.gts, 0, 0));

        // Seteo el adaptador del fragment dinamico
        adaptadorCoches = new SecondFragmentLista.AdaptadorCoches((AppCompatActivity) context, listaFiltrada);
    }

    // Metodo para recibir el dato segun el cual filtrar la informacion
    public void comunicarDato(String marca){
        // Modifica la lista para enseñar solo los coches de esa marca
        for ( Coche item : arrayCoches ) {
            if (item.getMarca().equalsIgnoreCase(marca)){
                listaFiltrada.add(item);
            }
        }
        /*
        for (Coche i : listaFiltrada) {
            Log.v("listaFiltrada", i.getModelo() );
        }
        */
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

        AdaptadorCoches(AppCompatActivity context, ArrayList<Coche> arrayData) {
            super(context, R.layout.list_item_coche, arrayData);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_coche, null);

            // Imagen del modelo
            ImageView imgCoche = item.findViewById(R.id.imgCoche);
            imgCoche.setImageResource(listaFiltrada.get(position).getImg());

            //Texto del modelo
            TextView txtCoche = item.findViewById(R.id.txtCoche);
            txtCoche.setText(listaFiltrada.get(position).getModelo());

            return(item);
        }

    }

}