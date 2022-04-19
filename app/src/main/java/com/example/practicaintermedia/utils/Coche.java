package com.example.practicaintermedia.utils;

public class Coche {

    private final String marca;
    private String modelo;
    private int img;
    private final int cvPower;
    private final float precio;

    public Coche(String marca, String modelo, int img, int cvPower, float precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.img = img;
        this.cvPower = cvPower;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getCvPower() {
        return cvPower;
    }

    public float getPrecio() {
        return precio;
    }
}
