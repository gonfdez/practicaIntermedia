package com.example.practicaintermedia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

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

        // Manejo de la toolbar
        android.support.v7.widget.Toolbar tool = findViewById(R.id.toolbar);
        setSupportActionBar(tool);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fragmentManager = getSupportFragmentManager();
        fragmentDetalle = (ThirdFragmentDetalle) fragmentManager.findFragmentById(R.id.fragment_detalle_coches);

        // Comunico de que coche hay que mostrar los detalles
        fragmentDetalle.comunicarCoche(coche);

    }

    // Metodo para inflar el menu
    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Metodo para coger los eventos click en el menu
    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch (item.getItemId())
        {
            // Si pulsa compartir envia correo electronico
            // Probema: a veces se queda pillado en una pantalla en la que sale "wait for sync" no se porque
            // ni como solucionarlo
            case R.id.action_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new
                        String[]{"direccion@ext.live.u-tad.es"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Hecha un vistazo al "+ coche.getModelo());
                intent.putExtra(Intent.EXTRA_TEXT, "El nuevo "+ coche.getModelo()+" de "+coche.getMarca()+" tiene "+coche.getCvPower()+" caballos y lo puedes comprar desde "+coche.getPrecio()+"€.\n¡Que pasada!");
                intent.setType("message/rfc822");
                startActivity(intent);
                return true;
        }
        return false;
    }

}
