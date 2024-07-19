package ar.edu.unlu.bridge;

import ar.edu.unlu.bridge.figuras.Figura;
import ar.edu.unlu.bridge.figuras.Linea;
import ar.edu.unlu.bridge.figuras.Rectangulo;
import ar.edu.unlu.bridge.figuras.TrianguloRectangulo;
import ar.edu.unlu.bridge.graficador.DefPuntos;
import ar.edu.unlu.bridge.graficador.Lienzo;
import ar.edu.unlu.bridge.trazos.DePunto;
import ar.edu.unlu.bridge.trazos.Doble;
import ar.edu.unlu.bridge.trazos.Normal;
import ar.edu.unlu.bridge.trazos.Trazable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graficador {
    public JPanel window;
    private JButton btnLinea;
    private JButton btnRectangulo;
    private JButton btnTriangulo;
    private JPanel panelCentral;
    private JRadioButton rbSimple;
    private JRadioButton rbDoble;
    private JRadioButton rbDePunto;
    private JRadioButton[] lineas = new JRadioButton[3];
    private int lineSelector = 0;
    private Trazable trazo = new Normal();

    public static void main(String[] args) {
        JFrame window = new JFrame("Graficador");
        Graficador app = new Graficador();
        app.initialize();
        window.setContentPane(app.window);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(100, 100, 650, 500);
        window.setVisible(true);
    }
    private void initialize(){
        lineas[0] = rbSimple;
        lineas[1] = rbDoble;
        lineas[2] = rbDePunto;
        activarLinea(0);

        btnLinea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLinea();
            }
        });
        btnRectangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onRectangulo();
            }
        });
        btnTriangulo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onTriangulo();
            }
        });
        rbSimple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                activarLinea(0);
            }
        });
        rbDoble.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                activarLinea(1);
            }
        });
        rbDePunto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                activarLinea(2);
            }
        });
    }
    private void onLinea() {
        Integer[] param = getPuntos();
        if (param[0] != -1 || param[1] != -1 || param[2] != -1  || param[3] != -1){
            Figura fig = new Linea();
            fig.setTrazo(trazo);
            ((Lienzo) panelCentral).addFigura(fig, param);
        };
    }
    private void onRectangulo() {
        Integer[] param = getPuntos();
        if (param[0] != -1 || param[1] != -1 || param[2] != -1  || param[3] != -1){
            Figura fig = new Rectangulo();
            System.out.println(fig.getClass() + " -> " + trazo.getClass());
            fig.setTrazo(trazo);
            ((Lienzo) panelCentral).addFigura(fig, param);

        };
    }
    private void onTriangulo() {
        Integer[] param = getPuntos();
        if (param[0] != -1 || param[1] != -1 || param[2] != -1  || param[3] != -1){
            Figura fig = new TrianguloRectangulo();
            fig.setTrazo(trazo);
            ((Lienzo) panelCentral).addFigura(fig, param);
        };
    }

    private Integer[] getPuntos() {
        DefPuntos puntos = new DefPuntos();
        puntos.setTitle("Coordenadas");
        puntos.setModal(true);
        Integer[] param = puntos.showDialog();
        return param;
    }

    private void activarLinea(int pos) {
        lineas[lineSelector].setSelected(false);
        lineas[pos].setSelected(true);
        lineSelector = pos;
        switch (lineSelector) {
            case 0:
                trazo = new Normal();
                break;
            case 1:
                trazo = new Doble();

                break;
            case 2:
                trazo = new DePunto();
                break;
        }
    }

    private void createUIComponents() {
        panelCentral = new Lienzo();
    }
}
