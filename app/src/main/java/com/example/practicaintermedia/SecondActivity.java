package com.example.practicaintermedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.example.practicaintermedia.fragments.FragmentLista;
import com.example.practicaintermedia.fragments.SecondFragmentLista;
import com.example.practicaintermedia.utils.Coche;


public class SecondActivity extends AppCompatActivity implements SecondFragmentLista.OnFragmentCocheListener {

    private SecondFragmentLista fragmentLista;
    private String marca;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Capturo el string de la marca seleccionada en la MainActivity
        marca = getIntent().getExtras().getString("marca");
        // Log.v("comunicacion",marca);

        fragmentManager = this.getSupportFragmentManager();
        fragmentLista = (SecondFragmentLista) fragmentManager
                .findFragmentById(R.id.fragment_dinamico_coches);

        //Comunico al fragment que datos debe mostrar
        fragmentLista.comunicarDato(marca);
    }

    // 5º paso: defino el metodo que se ejecuta al seleccionar.
    // Llama a la segunda activity pasandola el objeto marca en cuestión.
    @Override
    public void onCocheSelected(Coche coche) {
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        intent.putExtra("coche", coche);
        startActivity(intent);
    }


}
