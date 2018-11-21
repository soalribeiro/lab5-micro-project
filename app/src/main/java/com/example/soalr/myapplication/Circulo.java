package com.example.soalr.myapplication;

public class Circulo {
    int radius;
    Ponto2D centro;

    public Circulo(Ponto2D c) {
        radius = 0;
        centro = c;
    }

    //Calcula perímetro de um círculo
    public Double CalcPerCirc(){
        Double PerCirc = 2 * Math.PI * radius;
        return PerCirc;
    }

    //Calcula área de um círculo
    public Double CalcAreaCirc(){
        Double AreaCirc = Math.PI * (radius^2);
        return AreaCirc;
    }
}
