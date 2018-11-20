package com.example.soalr.myapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MyView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = findViewById(R.id.tela);

    }



    //Figuras
    public void fig1(View vs) { //circ
        v.setfigure(1);
        v.Resetar(1);
        v.invalidate();
    }

    public void fig2(View figura_escolha) { //reta
        v.setfigure(2);
        v.Resetar(1);
        v.invalidate();
    }

    public void fig3(View poli) { //poligono
        EditText ladosPoli = (EditText) findViewById(R.id.lados);
        int lados = Integer.parseInt(ladosPoli.getText().toString());
        v.Resetar(1);
        v.setfigure(3);
        v.invalidate();

        if(lados < 3){
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("ALERTA");
            alert.setMessage("Insira um número que seja pelo menos 3.");
            alert.setNeutralButton("Fechar", null);
            alert.show();
        }

        v.verLados(lados);
    }


    //Cores
    public void mudaCor1(View cor1) {
        v.Cor1_mudar(1);
        v.invalidate();
    }

    public void mudaCor2(View cor2) {
        v.Cor1_mudar(2);
        v.invalidate();
    }

    public void mudaCor3(View vcor) {
        v.Cor1_mudar(3);
        v.invalidate();
    }

    public void mudaCor4(View vcor2) {
        v.Cor1_mudar(4);
        v.invalidate();
    }

    public void Reset (View reset){
        v.Resetar(2);
        v.invalidate();
    }
}
