package com.example.soalr.myapplication;

public class Ponto2D {
    int x, y;

    public Ponto2D() {
        this.x = 0;
        this.y = 0;
    }

    public Ponto2D(int a, int b) {
        x = a;
        y = b;
    }

    public Double dist(Ponto2D P1) {
        Double distPontos = Math.sqrt((this.x - P1.x)^2 + (this.y - P1.y)^2);
        return distPontos;
    }

    public Double distCentro(){
        Ponto2D distanciaCentro = new Ponto2D(0,0);
        return this.dist(distanciaCentro);
    }

}
