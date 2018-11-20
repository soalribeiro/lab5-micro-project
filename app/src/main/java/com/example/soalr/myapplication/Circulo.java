package com.example.soalr.myapplication;

import java.util.Vector;

public class Circulo {
    int radius;
    Ponto2D centro;
    Vector<Ponto2D> ptsCirc = new Vector<Ponto2D>();

    public Circulo(Ponto2D c) {
        radius = 0;
        centro = c;

        ptsCirc.add(c);
    }

    public Double CalcPerCirc(){
        Double PerCirc = 2 * Math.PI * radius;
        return PerCirc;
    }

    public Double CalcAreaCirc(){
        Double AreaCirc = Math.PI * (radius^2);
        return AreaCirc;
    }
}
