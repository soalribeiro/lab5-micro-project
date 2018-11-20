package com.example.soalr.myapplication;

import java.util.Vector;

public class Poligono extends Reta {
    private int total_lados;
    Vector<Ponto2D> pontosPolig = new Vector<Ponto2D>();
    private Double PerPoligono;

    public Poligono(int lados_total) {

         total_lados = lados_total;

        for (int i = 0; i <= total_lados; i++) {
            int random = (int)(Math.random() * ((500 - 90) + 1) + 90);
            int random2 = (int)(Math.random() * ((500 - 90) + 1) + 90);

            Ponto2D ptArray = new Ponto2D(random, random2);
            pontosPolig.add(ptArray);
        }
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