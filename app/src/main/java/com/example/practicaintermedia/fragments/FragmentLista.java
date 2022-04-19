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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.practicaintermedia.R;
import com.example.practicaintermedia.utils.Marca;



//Clase que instancia el Fragmento

public class FragmentLista extends Fragment {

    private View view;
    private ListView listaMarcas;
    private ArrayAdapter<Marca> adaptadorMarcas;
    private ArrayList<Marca> arrayMarcas;

    // 1º paso: defino interfaz de call back
    public interface OnFragmentMarcaListener{
        void onMarcaSelected(Marca marca);
    }
    // 2º paso: Creo la interfaz
    private OnFragmentMarcaListener listener;



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        arrayMarcas = new ArrayList();

        arrayMarcas.add(new Marca("BMW", R.drawable.bmw));
        arrayMarcas.add(new Marca("Tesla",R.drawable.mercedes));
        arrayMarcas.add(new Marca("Mercedes Benz",R.drawable.tesla));
        arrayMarcas.add(new Marca("Ferrari",R.drawable.ferrari));
        arrayMarcas.add(new Marca("Audi",R.drawable.audi));
        arrayMarcas.add(new Marca("Opel",R.drawable.opel));
        arrayMarcas.add(new Marca("Lamborghini",R.drawable.lamborghini));
        arrayMarcas.add(new Marca("Volvo",R.drawable.volvo));
        arrayMarcas.add(new Marca("McLaren",R.drawable.mclaren));
        arrayMarcas.add(new Marca("Volkswagen",R.drawable.volkswagen));
        arrayMarcas.add(new Marca("Peugeot",R.drawable.peugeot));
        arrayMarcas.add(new Marca("Seat",R.drawable.seat));

        adaptadorMarcas = new AdaptadorMarcas((AppCompatActivity) context);
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
        listaMarcas = view.findViewById(R.id.listaMarcas_fragment);
        listaMarcas.setAdapter(adaptadorMarcas);

        //4º Paso: Seteamos la comunicacion al clickarse una casilla de Marca
        listaMarcas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Marca marca = adaptadorMarcas.getItem(i);
                listener.onMarcaSelected(marca);
            }
        });

        }

    class AdaptadorMarcas extends ArrayAdapter<Marca> {

        AppCompatActivity appCompatActivity;
        AdaptadorMarcas(AppCompatActivity context) {
            super(context, R.layout.list_item_marca, arrayMarcas);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_marca, null);
            TextView txtMarca = item.findViewById(R.id.txtMarca);
            txtMarca.setText(arrayMarcas.get(position).getNombre());
            ImageView imgMarca = item.findViewById(R.id.imgMarca);
            imgMarca.setImageResource(arrayMarcas.get(position).getImg());
            return(item);
        }
    }    
        
}





