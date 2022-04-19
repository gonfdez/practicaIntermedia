package com.example.practicaintermedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.example.practicaintermedia.fragments.SecondFragmentLista;

public class SecondActivity extends AppCompatActivity {

    private SecondFragmentLista fragmentLista;
    private String marca;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Capturo el string de la marca seleccionada en la MainActivity
        marca = getIntent().getExtras()
                .getString("marca");
        Log.v("comunicacion",marca);

        fragmentManager = this.getSupportFragmentManager();
        fragmentLista = (SecondFragmentLista) fragmentManager
                .findFragmentById(R.id.fragment_dinamico_coches);

        //Comunico al fragments que datos debe mostrar
        fragmentLista.comunicarDato(marca);
    }

}
