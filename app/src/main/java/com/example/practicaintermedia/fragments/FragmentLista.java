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

import java.util.ArrayList;

import com.example.practicaintermedia.R;
import com.example.practicaintermedia.adaptadores.AdapterMarcas;
import com.example.practicaintermedia.utils.Marca;

public class FragmentLista extends Fragment {

    private View view;
    private ArrayList<Marca> arrayMarcas;
    private RecyclerView listaMarcas;
    private AdapterMarcas adapterMarcas;
    private Context contexto;

    // Gestion de evento click en el Recycler (Pasos anteriores en AdapterMarcas)
    // 5º Genero una interfaz de callback para llamar a la Activity cuando una
    // marca es seleccionada y poder cambiar de Activity
    public interface OnFragmentMarcaListener{
        void onMarcaSelected(Marca marca);
    }
    // 6º Genero una instancia de la interfaz para poder llamar al metodo onMarcaSelected
    private OnFragmentMarcaListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Necesito guardar el contexto para configurar el recycler cuando se genera la vista
        this.contexto = context;

        // Gestiono la lista de marcas
        arrayMarcas = new ArrayList();
        arrayMarcas.add(new Marca("BMW", R.drawable.bmw));
        arrayMarcas.add(new Marca("Tesla",R.drawable.tesla));
        arrayMarcas.add(new Marca("Mercedes Benz",R.drawable.mercedes));
        arrayMarcas.add(new Marca("Ferrari",R.drawable.ferrari));
        arrayMarcas.add(new Marca("Audi",R.drawable.audi));
        arrayMarcas.add(new Marca("Opel",R.drawable.opel));
        arrayMarcas.add(new Marca("Lamborghini",R.drawable.lamborghini));
        arrayMarcas.add(new Marca("Volvo",R.drawable.volvo));
        arrayMarcas.add(new Marca("McLaren",R.drawable.mclaren));
        arrayMarcas.add(new Marca("Volkswagen",R.drawable.volkswagen));
        arrayMarcas.add(new Marca("Peugeot",R.drawable.peugeot));
        arrayMarcas.add(new Marca("Seat",R.drawable.seat));

        // Ahora generamos el adaptador con la lista de marcas
        adapterMarcas=new AdapterMarcas( (AppCompatActivity) context, arrayMarcas);

        // 7º Doy valor al listener creado
        listener = (OnFragmentMarcaListener) context;
        // 8º Generamos el metodo OnClickListener que
        // gestiona el evento proveniente del elemento clickado en el adaptador
        adapterMarcas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Encuentro el elemento clickado
                Marca marca = arrayMarcas.get(listaMarcas.getChildAdapterPosition(view));
                // Le envio a Activity el objeto Marca correspondiente
                listener.onMarcaSelected(marca);
            }
        });
        // Siguientes pasos en la activity correspondiente a este fragment (MainActivity)
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
        listaMarcas = view.findViewById(R.id.recyclerId);
        // Configuro el Recycler para que sea una lista vertical
        listaMarcas.setLayoutManager(new LinearLayoutManager(contexto, LinearLayoutManager.VERTICAL,false));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Pasamos el adaptador al Recycler para que se infle con los datos
        listaMarcas.setAdapter(adapterMarcas);
    }

}





