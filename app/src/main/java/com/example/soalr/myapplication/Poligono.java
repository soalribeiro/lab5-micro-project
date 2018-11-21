package com.example.soalr.myapplication;

import java.util.Vector;

public class Poligono extends Reta {
    private int total_lados;

    public Vector<Ponto2D> pontosPolig;// = new Vector<Ponto2D>();
    private Double PerPoligono;

    public Poligono(float lados_X, float lados_Y) {
        pontosPolig = new Vector<Ponto2D>();
        Ponto2D p1 = new Ponto2D(lados_X, lados_Y);
        pontosPolig.add(p1);
    }
    public Poligono() {
         pontosPolig = new Vector<Ponto2D>();
    }
public void addpoint(Ponto2D aux)
{
    pontosPolig.add(aux);
}
    public Double CalcPerPoligono() {
        for (int i = 0; i <= total_lados; i++) {
            Ponto2D pinicial = pontosPolig.get(i);
            Ponto2D pfinal = pontosPolig.get(i + 1);
            PerPoligono += pinicial.dist(pfinal);
        }
        return PerPoligono;
    }

}