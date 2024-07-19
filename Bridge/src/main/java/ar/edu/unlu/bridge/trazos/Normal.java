package ar.edu.unlu.bridge.trazos;

import java.awt.*;

public class Normal implements Trazable{
    @Override
    public void addTrazo(Graphics2D g2) {
        BasicStroke trazo = new BasicStroke(1.0f);
        g2.setStroke(trazo);
    }
}
