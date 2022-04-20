package com.example.practicaintermedia;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.practicaintermedia.fragments.FragmentLista;
import com.example.practicaintermedia.utils.Marca;

// 3º paso: implemento la interfaz de call back
public class MainActivity extends AppCompatActivity implements FragmentLista.OnFragmentMarcaListener {

    private FragmentLista fragmentLista;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = this.getSupportFragmentManager();
        fragmentLista = (FragmentLista) fragmentManager
                .findFragmentById(R.id.fragment_estatico);



    }

    // 5º paso: defino el metodo que se ejecuta al seleccionar.
    // Llama a la segunda activity pasandola el objeto marca en cuestión.
    @Override
    public void onMarcaSelected(Marca marca) {
        //Log.v("comunicacion",marca.getNombre());
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("marca", marca.getNombre());
        startActivity(intent);
    }

}