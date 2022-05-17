package com.example.practicaintermedia.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practicaintermedia.R;
import com.example.practicaintermedia.utils.Coche;

public class ThirdFragmentDetalle extends Fragment  {

    private View view;
    private TextView marca, modelo, potencia, precio;
    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle,container, false);
        img = view.findViewById(R.id.img_detalle);
        marca = view.findViewById(R.id.marca_detalle);
        modelo = view.findViewById(R.id.modelo_detalle);
        potencia = view.findViewById(R.id.potencia_detalle);
        precio = view.findViewById(R.id.precio_detalle);
        return view;
    }
    
    public void comunicarCoche(Coche coche){
        img.setImageResource(coche.getImg());
        modelo.setText(coche.getModelo());
        marca.setText(coche.getMarca());
        potencia.setText(coche.getCvPower()+" cv");
        precio.setText(coche.getPrecio()+"€");
    }


}
