package com.example.practicaintermedia;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.practicaintermedia.fragments.SecondFragmentLista;
import com.example.practicaintermedia.fragments.ThirdFragmentDetalle;
import com.example.practicaintermedia.utils.Coche;

public class ThirdActivity extends AppCompatActivity {

    private ThirdFragmentDetalle fragmentDetalle;
    private FragmentManager fragmentManager;
    private Coche coche;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Capturo el objeto coche seleccionado en la SecondActivity y lo deseralizo
        coche = (Coche) getIntent().getExtras().getSerializable("coche");

        fragmentManager = this.getSupportFragmentManager();
        fragmentDetalle = (ThirdFragmentDetalle) fragmentManager
                .findFragmentById(R.id.fragment_detalle_coches);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentManager = getSupportFragmentManager();
        fragmentDetalle = (ThirdFragmentDetalle) fragmentManager.findFragmentById(R.id.fragment_detalle_coches);

        // Comunico de que coche hay que mostrar los detalles
        fragmentDetalle.comunicarCoche(coche);

    }

}
