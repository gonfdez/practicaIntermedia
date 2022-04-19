package com.example.practicaintermedia.utils;

import android.graphics.drawable.Drawable;

import com.example.practicaintermedia.R;

import java.io.Serializable;

public class Marca implements Serializable {

    private String nombre;
    private int img;

    public Marca(String nombre, int img) {
        this.nombre = nombre;
        this.img = img;

    }

    public int getImg() {
        return this.img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    public String getNombre() {
        return nombre;
    }

}

