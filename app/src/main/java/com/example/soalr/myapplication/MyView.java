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
    int cor;
    int deletar;
    float CursorX, CursorY;
    Vector<Ponto2D> ptsCirc;
    Vector<Ponto2D> ptsReta;
    Vector<Reta> guardaRetas;
    Poligono ptsPoli;

    public MyView(Context context) {
        super(context);
        paint = new Paint();
        figure = 0;
        cor = 0;
        ptsCirc = new Vector<Ponto2D>();
        ptsReta = new Vector<Ponto2D>();
        guardaRetas = new Vector<Reta>();
        ptsPoli = new Poligono();

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStrokeWidth(10);
        figure = 0;
        cor = 0;
        ptsCirc = new Vector<Ponto2D>();
        ptsReta = new Vector<Ponto2D>();
        guardaRetas = new Vector<Reta>();
        ptsPoli = new Poligono();

    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        paint = new Paint();
        figure = 0;
        cor = 0;
        ptsCirc = new Vector<Ponto2D>();
        ptsReta = new Vector<Ponto2D>();
        guardaRetas = new Vector<Reta>();
        ptsPoli = new Poligono();
    }

    //Evento do click
    public boolean onTouchEvent (MotionEvent event)
    {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:

            case MotionEvent.ACTION_UP:

                CursorX = event.getX();
                CursorY = event.getY();

                if (figure == 1) {
                    Ponto2D centroCirc = new Ponto2D();
                    centroCirc.x = CursorX;
                    centroCirc.y = CursorY;
                    ptsCirc.add(centroCirc);
                    invalidate();
                }

                if (figure == 2) {
                    Ponto2D ptReta = new Ponto2D();
                    ptReta.x = CursorX;
                    ptReta.y = CursorY;
                    ptsReta.add(ptReta);
                    if (ptsReta.size() %2 == 0) {
                        invalidate();
                    }
                }

                if (figure == 3) {
                    Ponto2D ptPoli = new Ponto2D();
                    ptPoli.x = CursorX;
                    ptPoli.y = CursorY;
                    ptsPoli.addpoint(ptPoli);
                    invalidate();
                }

            default:
                return false;
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //pinta a tela
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#F5F1E0"));
        canvas.drawPaint(paint);
        //pinta o objeto se não for selecionada nenhuma cor
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


        //figura 1 --> Círculo
        if (figure == 1) {
            if (ptsCirc.size() > 0) {
                for (int a = 0; a < ptsCirc.size(); a++) {
                    Circulo raio = new Circulo(ptsCirc.get(a));
                    raio.radius = 80;
                    canvas.drawCircle(ptsCirc.get(a).x, ptsCirc.get(a).y, raio.radius, paint);
                }
            }
        }

        //figura 2 --> Reta
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

        //figura 3 --> Polígono
        if (figure == 3) {
            if (ptsPoli.pontosPolig.size() > 0) {
                    for (int p = 1; p < ptsPoli.pontosPolig.size(); p++) {
                        if (p == ptsPoli.pontosPolig.size() - 1) {
                            canvas.drawLine(ptsPoli.pontosPolig.get(p).x, ptsPoli.pontosPolig.get(p).y, ptsPoli.pontosPolig.get(0).x, ptsPoli.pontosPolig.get(0).y, paint);
                        }
                        canvas.drawLine(ptsPoli.pontosPolig.get(p).x, ptsPoli.pontosPolig.get(p).y, ptsPoli.pontosPolig.get(p - 1).x, ptsPoli.pontosPolig.get(p - 1).y, paint);
                    }
                }
        }

        //Limpar tela
        if (deletar == 2) {
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#F5F1E0"));
            canvas.drawPaint(paint);
            ptsCirc.removeAllElements();
            ptsReta.removeAllElements();
            guardaRetas.removeAllElements();
            ptsPoli.pontosPolig.removeAllElements();
        }
    }


    public void setfigure(int a) {
        this.figure = a;
    }

    public void Cor1_mudar(int text_cor) {
        this.cor = text_cor;
    }

    public void Resetar(int delete){
        this.deletar = delete;
    }
}