package com.example.practicaintermedia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practicaintermedia.R;
import com.example.practicaintermedia.adaptadores.AdapterCoches;
import com.example.practicaintermedia.utils.Coche;

import java.util.ArrayList;

public class SecondFragmentLista extends Fragment {

    private View view;
    private ArrayList<Coche> arrayCoches, listaFiltrada;
    private RecyclerView listaCoches;
    private AdapterCoches adapterCoches;
    private Context contexto;

    // Gestion de evento click en el Recycler (Pasos anteriores en AdapterCoches)
    // 5º Genero una interfaz de callback para llamar a la Activity cuando una
    // coche es seleccionada y poder cambiar de Activity
    public interface OnFragmentCocheListener{
        void onCocheSelected(Coche coche);
    }
    // 6º Genero una instancia de la interfaz para poder llamar al metodo onCocheSelected
    private OnFragmentCocheListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Necesito guardar el contexto para configurar el recycler cuando se genera la vista
        this.contexto = context;

        // Gestiono la lista de coches
        arrayCoches = new ArrayList<Coche>();
        listaFiltrada = new ArrayList<Coche>();

        arrayCoches.add(new Coche("BMW", "X1", R.drawable.x1, 150, 34750));
        arrayCoches.add(new Coche("BMW", "X2 Híbrido Enchufable", R.drawable.x2, 178, 49300));
        arrayCoches.add(new Coche("BMW", "X3", R.drawable.x3, 360, 52600));

        arrayCoches.add(new Coche("Tesla", "Model 3 Bev Long Range", R.drawable.model3, 491, 51990));
        arrayCoches.add(new Coche("Tesla", "Model Y Bev Long Range", R.drawable.modely, 514, 66970));
        arrayCoches.add(new Coche("Tesla", "Model S Plaid+", R.drawable.models, 1100, 89900));
        arrayCoches.add(new Coche("Tesla", "Model X Bev Long Range", R.drawable.modelx, 670, 115970));
        arrayCoches.add(new Coche("Tesla", "Roadster", R.drawable.roadster, 1500, 172000));

        arrayCoches.add(new Coche("Mercedes Benz", "Clase A 180", R.drawable.clasea, 136, 31579));
        arrayCoches.add(new Coche("Mercedes Benz", "Clase B 180", R.drawable.claseb, 136, 35167));
        arrayCoches.add(new Coche("Mercedes Benz", "Clase C 180", R.drawable.clasec, 170, 39062));
        arrayCoches.add(new Coche("Mercedes Benz", "Clase E 450 4MATIC", R.drawable.clasee, 367, 73384));
        arrayCoches.add(new Coche("Mercedes Benz", "Clase G", R.drawable.claseg, 585, 137607));

        arrayCoches.add(new Coche("Ferrari", "250 Testarossa", R.drawable.testarossa, 390, 130000));
        arrayCoches.add(new Coche("Ferrari", "458 Spider", R.drawable.spider, 570, 257899));
        arrayCoches.add(new Coche("Ferrari", "LaFerrari", R.drawable.laferrari, 800, 13000000));
        arrayCoches.add(new Coche("Ferrari", "812 GTS", R.drawable.gts, 799, 339000));

        arrayCoches.add(new Coche("Audi", "Q3", R.drawable.q3, 190, 43700));
        arrayCoches.add(new Coche("Audi", "A5", R.drawable.a5, 215, 57600));
        arrayCoches.add(new Coche("Audi", "RS7 Sportback", R.drawable.rs7, 430, 132900));

        arrayCoches.add(new Coche("Opel", "Vivaro", R.drawable.vivaro, 215, 38700));
        arrayCoches.add(new Coche("Opel", "Insignia", R.drawable.insignia, 140, 24500));

        arrayCoches.add(new Coche("Lamborghini", "Huracan", R.drawable.huracan, 600, 110900));
        arrayCoches.add(new Coche("Lamborghini", "Aventador", R.drawable.aventador, 880, 175890));
        arrayCoches.add(new Coche("Lamborghini", "Gallardo", R.drawable.gallardo, 740, 145900));
        arrayCoches.add(new Coche("Lamborghini", "Diablo", R.drawable.diablo, 410, 196800));

        arrayCoches.add(new Coche("Volvo", "XC 90", R.drawable.xc90, 320, 67590));
        arrayCoches.add(new Coche("Volvo", "XC 60", R.drawable.xc60, 150, 36900));

        arrayCoches.add(new Coche("McLaren", "P1 GTR", R.drawable.p1, 1150, 360900));
        arrayCoches.add(new Coche("McLaren", "650S", R.drawable.s650, 750, 240900));
        arrayCoches.add(new Coche("McLaren", "F1 GTR", R.drawable.f1gtr, 870, 352900));
        arrayCoches.add(new Coche("McLaren", "MP4-12C", R.drawable.mp4, 660, 256850));

        arrayCoches.add(new Coche("Volkswagen", "Golf", R.drawable.golf, 115, 17500));

        arrayCoches.add(new Coche("Peugeot", "406", R.drawable.bravolimamike, 90, 500));

        arrayCoches.add(new Coche("Seat", "Ibiza", R.drawable.ibiza, 115, 14500));

        // Ahora generamos el adaptador con la lista de coches filtrados
        adapterCoches=new AdapterCoches( (AppCompatActivity) context, listaFiltrada);

        // 7º Doy valor al listener creado
        listener = (OnFragmentCocheListener) context;
        // 8º Generamos el metodo OnClickListener que
        // gestiona el evento proveniente del elemento clickado en el adaptador
        adapterCoches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Encuentro el elemento clickado
                Coche coche = listaFiltrada.get(listaCoches.getChildAdapterPosition(view));
                // Le envio a Activity el objeto Coche correspondiente
                listener.onCocheSelected(coche);
            }
        });
        // Siguientes pasos en la activity correspondiente a este fragment (SecondActivity)
    }

    // Metodo para recibir el dato segun el cual filtrar la informacion
    public void comunicarDato(String coche){
        listaFiltrada.clear();
        // Modifica la lista para enseñar solo los coches de esa coche
        for ( Coche item : arrayCoches ) {
            if (item.getMarca().equalsIgnoreCase(coche)){
                listaFiltrada.add(item);
            }
        }
        adapterCoches.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Encuentro el xml del fragment
        view = inflater.inflate(R.layout.fragment_lista_recycler,container,
                false);
        // Encuentro el RecyclerView
        listaCoches = view.findViewById(R.id.recyclerId);
        // Configuro el Recycler para que sea una lista vertical
        listaCoches.setLayoutManager(new LinearLayoutManager(contexto, LinearLayoutManager.VERTICAL,false));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Pasamos el adaptador al Recycler para que se infle con los datos
        listaCoches.setAdapter(adapterCoches);
    }

}