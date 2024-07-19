package ar.edu.unlu.bridge.figuras;

import ar.edu.unlu.bridge.trazos.Normal;
import ar.edu.unlu.bridge.trazos.Trazable;

import java.awt.*;

public abstract class Figura {
    private Trazable miTrazo = new Normal();
    public abstract void dibujar(Graphics2D g2, Integer[] parametros);

    public void setTrazo(Trazable trazable) {
        miTrazo = trazable;
    }
    public Trazable getTrazo() {
        return  miTrazo;
    }



}
