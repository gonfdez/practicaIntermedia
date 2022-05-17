package com.example.practicaintermedia.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practicaintermedia.R;
import com.example.practicaintermedia.utils.Coche;

import java.util.ArrayList;

// 1º 2/2 Implemento la interfaz View.OnclickListener al adaptador
public class AdapterCoches extends RecyclerView.Adapter<AdapterCoches.ViewHolderCoche> implements View.OnClickListener {

    AppCompatActivity appCompatActivity;
    private ArrayList<Coche> arrayCoches;

    public AdapterCoches(AppCompatActivity context, ArrayList<Coche> arrayCoches) {
        this.appCompatActivity = context;
        this.arrayCoches = arrayCoches;

    }

    // Gestion de eventos click en los elementos del recycler
    // 1º 1/2 Paso generar generar el escuchador
    private View.OnClickListener listener;

    @NonNull
    @Override
    // Nos enlaza el adaptador con el archivo item_list_coche
    public AdapterCoches.ViewHolderCoche onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.list_item_coche, null);

        // 2º Paso ponemos el escuchador a escuchar
        itemView.setOnClickListener((View.OnClickListener) this);

        return new AdapterCoches.ViewHolderCoche(itemView);
    }

    // 3º Paso generamos metodo setOnClickListener que se encarga de dar valor al listener
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    // 4º Paso genero un metodo de validacion para el escuchador
    public void onClick(View view){
        if (listener !=null){
            listener.onClick(view);
        }
    }
    // Siguiente paso en el fragment que recibe el evento (SecondFragmentLista)

    @Override
    // Encargado de establecer la comunicacion entre el adaptador y la clase ViewHolderCoche
    public void onBindViewHolder(@NonNull AdapterCoches.ViewHolderCoche holder, int position) {
        holder.asignarDatos(arrayCoches.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayCoches.size();
    }

    public class ViewHolderCoche extends RecyclerView.ViewHolder {
        // Declaro los elementos xml de list_item_coche
        TextView txtCoche;
        ImageView imgCoche;

        public ViewHolderCoche(@NonNull View itemView) {
            super(itemView);
            // Encuentro los elementos del xml
            txtCoche = itemView.findViewById(R.id.txtCoche);
            imgCoche = itemView.findViewById(R.id.imgCoche);
        }

        // Metodo para pasar los datos de cada objeto a los elementos del xml
        public void asignarDatos(Coche coche) {
            imgCoche.setImageResource(coche.getImg());
            txtCoche.setText(coche.getModelo());
        }
    }
}
