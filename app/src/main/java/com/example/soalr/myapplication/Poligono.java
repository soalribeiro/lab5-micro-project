package com.example.soalr.myapplication;

import java.util.Vector;

public class Poligono {

    public Vector<Ponto2D> pontosPolig;
    private Double PerPoligono;

    public Poligono() {
        pontosPolig = new Vector<Ponto2D>();
    }

    public Poligono(float lados_X, float lados_Y) {
        pontosPolig = new Vector<Ponto2D>();
        Ponto2D p1 = new Ponto2D(lados_X, lados_Y);
    }

    public void addpoint(Ponto2D aux) {
        pontosPolig.add(aux);
    }

    public Double CalcPerPoligono() {
        for (int i = 0; i <= pontosPolig.size(); i++) {
            Ponto2D pinicial = pontosPolig.get(i);
            Ponto2D pfinal = pontosPolig.get(i + 1);
            PerPoligono += pinicial.dist(pfinal);
        }
        return PerPoligono;
    }

}