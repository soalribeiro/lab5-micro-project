package com.example.soalr.myapplication;

public class Circulo {
    int radius;
    Ponto2D centro;

    public Circulo(Ponto2D c) {
        radius = 0;
        centro = c;
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
