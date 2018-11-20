package com.example.soalr.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;


public class MyView extends View {
    Paint paint = null;
    int figure;
    int lados_poly;
    int cor;
    int deletar;
    Circulo cir;
    int CursorX, CursorY;
    int nrCliques;

    public MyView(Context context) {
        super(context);
        paint = new Paint();
        figure = 0;
        cor = 0;


    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStrokeWidth(10);
        figure = 0;
        cor = 0;

        Ponto2D centroCirc = new Ponto2D();
        centroCirc.x = CursorX;
        centroCirc.y = CursorY;
        cir = new Circulo(centroCirc);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint = new Paint();
        figure = 0;
        cor = 0;

    }


    public void clickEcra() {
        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:

                    case MotionEvent.ACTION_UP:

                        CursorX = (int)event.getX();
                        CursorY = (int)event.getY();

                    default:
                        nrCliques++;
                        System.out.println("clique: " + nrCliques);
                        return false;
                }
            }
        });
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        clickEcra();

        //uso da class Reta
        Ponto2D p1 = new Ponto2D();
        p1.x = (int)(Math.random() * ((500 - 90) + 1) + 90);
        p1.y = (int)(Math.random() * ((400 - 90) + 1) + 90);
        Ponto2D p2 = new Ponto2D();
        p2.x = (int)(Math.random() * ((500 - 90) + 1) + 90);
        p2.y = (int)(Math.random() * ((400 - 90) + 1) + 90);

        Ponto2D p3 = new Ponto2D();
        p3.x = 600;
        p3.y = 150;

        Reta retinha = new Reta(p1, p2);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#F5F1E0"));
        canvas.drawPaint(paint);
        paint.setColor(Color.parseColor("#3F5866"));

        //cores
        if (cor == 1) {
            paint.setColor(Color.parseColor("#393E46"));
        } else if (cor == 2){
            paint.setColor(Color.parseColor("#00ADB5"));
        } else if (cor == 3) {
            paint.setColor(Color.parseColor("#F8B500"));
        } else if (cor == 4) {
            paint.setColor(Color.parseColor("#FC3C3C"));
        }


        //figuras
        if (figure == 1) {
            Ponto2D centroCirc = new Ponto2D();
            clickEcra();
            centroCirc.x = CursorX;
            centroCirc.y = CursorY;
            Circulo raio = new Circulo(centroCirc);
            raio.radius = 100;
            if (nrCliques > 0) {
                //for (int a = 0; a <= nrCliques; a++) {
                    canvas.drawCircle(centroCirc.x, centroCirc.y, raio.radius, paint);
                //} ver de manha
            }
            invalidate();
        } else if (figure == 2) {
            canvas.drawLine(retinha.pinicial.x, retinha.pinicial.y, retinha.pfinal.x, retinha.pfinal.y, paint);
        } else if (figure == 3) {
            Poligono poly = new Poligono(lados_poly);

            if (lados_poly >= 3) {
                for (int i = 0; i <= lados_poly - 1; i++) {
                    Ponto2D ponto4 = new Ponto2D(poly.pontosPolig.get(i).x, poly.pontosPolig.get(i).y);
                    Ponto2D ponto5 = new Ponto2D();

                    if (i < lados_poly) {
                        ponto5.x = poly.pontosPolig.get(i + 1).x;
                        ponto5.y = poly.pontosPolig.get(i + 1).y;

                        Reta retaPoli = new Reta(ponto4, ponto5);
                        int var_lados = lados_poly - 1;

                        if (i != var_lados) {
                            canvas.drawLine(retaPoli.pinicial.x, retaPoli.pinicial.y, retaPoli.pfinal.x, retaPoli.pfinal.y, paint);
                        } else {
                            canvas.drawLine(poly.pontosPolig.firstElement().x, poly.pontosPolig.firstElement().y, retaPoli.pinicial.x, retaPoli.pinicial.y, paint);
                        }

                    }
                }
            }
        }

        if (deletar == 2){
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#F5F1E0"));
            canvas.drawPaint(paint);
            nrCliques =0;
        }
    }




    public void setfigure(int a) {
        this.figure = a;
    }

    public void Cor1_mudar(int text_cor) {
        this.cor = text_cor;
    }

    public void verLados (int lados){
        this.lados_poly = lados;
    }

    public void Resetar(int delete){
        this.deletar = delete;
    }
}