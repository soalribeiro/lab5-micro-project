package com.example.soalr.myapplication;

public class Ponto2D {
    float x, y;

    public Ponto2D() {
        this.x = 0;
        this.y = 0;
    }

    public Ponto2D(float a, float b) {
        x = a;
        y = b;
    }

    //Calcula distância entre dois pontos
    public double dist(Ponto2D P1) {
        return Math.sqrt((x - P1.x) * (x - P1.x) + (y - P1.y) * (y - P1.y));
    }

    //Calcula distância ao ponto 0,0
    public Double distCentro(){
        Ponto2D distanciaCentro = new Ponto2D(0,0);
        return this.dist(distanciaCentro);
    }

}
