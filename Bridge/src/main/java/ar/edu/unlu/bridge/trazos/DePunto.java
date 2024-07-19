package ar.edu.unlu.bridge.trazos;

import java.awt.*;

public class DePunto implements Trazable {
    @Override
    public void addTrazo(Graphics2D g2) {
        float dash1[] = {10.0f};
        BasicStroke trazo =
                new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
        g2.setStroke(trazo);
    }
}
