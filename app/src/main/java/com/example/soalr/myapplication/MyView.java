package com.example.soalr.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.Vector;

public class MyView extends View {
    Paint paint = null;
    int figure;
    int lados_poly;
    int cor;
    int deletar;
    int CursorX, CursorY;
    int nrCliques;
    Vector<Ponto2D> ptsCirc = new Vector<Ponto2D>();
    Vector<Ponto2D> ptsReta = new Vector<Ponto2D>();
    Vector<Reta> guardaRetas = new Vector<Reta>();

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

//        Ponto2D centroCirc = new Ponto2D();
//        centroCirc.x = CursorX;
//        centroCirc.y = CursorY;
//        cir = new Circulo(centroCirc);
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

                        if (figure == 1) {
                            Ponto2D centroCirc = new Ponto2D();
                            centroCirc.x = CursorX;
                            centroCirc.y = CursorY;
                            ptsCirc.add(centroCirc);
                            invalidate();
                        }

                        if (figure == 2){
                            Ponto2D ptReta = new Ponto2D();
                            ptReta.x = CursorX;
                            ptReta.y = CursorY;
                            ptsReta.add(ptReta);
                            invalidate();
                        }

                    default:
                        return false;
                }
            }
        });
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        clickEcra();

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
            if (ptsCirc.size() > 0) {
                for (int a = 0; a < ptsCirc.size(); a++) {
                    Circulo raio = new Circulo(ptsCirc.get(a));
                    raio.radius = 100;
                    canvas.drawCircle(ptsCirc.get(a).x, ptsCirc.get(a).y, raio.radius, paint);
                }
            }
        }

        if (figure == 2) {
            if (ptsReta.size() %2 == 0) {
                for (int b = 0; b < ptsReta.size(); b = b + 2) {
                    Reta retinha = new Reta(ptsReta.get(b), ptsReta.get(b + 1));
                    guardaRetas.add(retinha);
                }

                if (guardaRetas.size() > 0) {
                    for (int r = 0; r < guardaRetas.size(); r++) {
                        canvas.drawLine(guardaRetas.get(r).pinicial.x, guardaRetas.get(r).pinicial.y, guardaRetas.get(r).pfinal.x, guardaRetas.get(r).pfinal.y, paint);
                    }
                }
            }
        }

        if (figure == 3) {
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
            nrCliques = 0;
            ptsCirc.removeAllElements();
            ptsReta.removeAllElements();
            guardaRetas.removeAllElements();
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