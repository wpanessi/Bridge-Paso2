package ar.edu.unlu.bridge.trazos;

import java.awt.*;

public class Doble implements Trazable{

    @Override
    public void addTrazo(Graphics2D g2) {
        BasicStroke trazo = new BasicStroke(2.0f);
        g2.setStroke(trazo);
    }
}
