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
import com.example.practicaintermedia.utils.Marca;

import java.util.ArrayList;

    // 1º 2/2 Implemento la interfaz View.OnclickListener al adaptador
public class AdapterMarcas extends RecyclerView.Adapter<AdapterMarcas.ViewHolderMarca> implements View.OnClickListener {

    AppCompatActivity appCompatActivity;
    private ArrayList<Marca> arrayMarcas;


    public AdapterMarcas(AppCompatActivity context, ArrayList<Marca> arrayMarcas) {
        this.appCompatActivity = context;
        this.arrayMarcas = arrayMarcas;

    }

    // Gestion de eventos click en los elementos del recycler
    // 1º 1/2 Paso generar generar el escuchador
    private View.OnClickListener listener;

    @NonNull
    @Override
    // Nos enlaza el adaptador con el archivo item_list_marca
    public AdapterMarcas.ViewHolderMarca onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        View itemView = inflater.inflate(R.layout.list_item_marca, null);

        // 2º Paso ponemos el escuchador a escuchar
        itemView.setOnClickListener((View.OnClickListener) this);

        return new ViewHolderMarca(itemView);
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
    // Siguiente paso en el fragment que recibe el evento (FragmentLista en este caso)

    @Override
    // Encargado de establecer la comunicacion entre el adaptador y la clase ViewHolderMarca
    public void onBindViewHolder(@NonNull AdapterMarcas.ViewHolderMarca holder, int position) {
        holder.asignarDatos(arrayMarcas.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayMarcas.size();
    }

    public class ViewHolderMarca extends RecyclerView.ViewHolder {
        // Declaro los elementos xml de list_item_marca
        TextView txtMarca;
        ImageView imgMarca;

        public ViewHolderMarca(@NonNull View itemView) {
            super(itemView);
            // Encuentro los elementos del xml
            txtMarca = itemView.findViewById(R.id.txtMarca);
            imgMarca = itemView.findViewById(R.id.imgMarca);
        }

        // Metodo para pasar los datos de cada objeto a los elementos del xml
        public void asignarDatos(Marca marca) {
            txtMarca.setText(marca.getNombre());
            imgMarca.setImageResource(marca.getImg());
        }
    }
}
