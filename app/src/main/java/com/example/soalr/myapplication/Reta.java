package com.example.soalr.myapplication;

public class Reta {
    Ponto2D pinicial;
    Ponto2D pfinal;

    public Reta(){
        pinicial = new Ponto2D();
        pfinal = new Ponto2D();
    }

    public Reta(Ponto2D a, Ponto2D b) {
        pinicial = a;
        pfinal = b;
    }

    public Ponto2D PontoMedio() {
        float respostaX = (pinicial.x - pfinal.x)/2;
        float respostaY = (pinicial.y - pfinal.y)/2;

        Ponto2D PtMedio = new Ponto2D(respostaX, respostaY);

        return PtMedio;
    }
}
