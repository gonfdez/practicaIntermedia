package com.example.practicaintermedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.practicaintermedia.fragments.SecondFragmentLista;

public class SecondActivity extends AppCompatActivity {

    private SecondFragmentLista fragmentLista;
    private String marca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        marca = getIntent().getExtras()
                .getString("marca");

        /*
        fragmentManager = this.getSupportFragmentManager();
        fragmentLista = (SecondFragmentLista) fragmentManager
                .findFragmentById(R.id.fragmente_estatico);
        //fragmentManager.findFragmentByTag("fragment_lista");
        fragmentLista.comunicarDato(desarrollador);
        */
    }

    /*
    @Override
    public void onJuegoSelected(Coche coche) {
        //Log.v("comunicacion",juego.getNombre());
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        intent.putExtra("coche", coche);
        startActivity(intent);
    }
    */





}
