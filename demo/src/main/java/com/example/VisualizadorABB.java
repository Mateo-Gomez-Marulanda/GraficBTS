package com.example;

import javax.swing.*;
import java.awt.*;

public class VisualizadorABB extends JFrame {
    private ArbolABB arbol = new ArbolABB();
    private JTextField txtDato = new JTextField(5);
    private JPanel canvas;

    public VisualizadorABB() {
        setTitle("ABB Visualizer - Java");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel de controles
        JPanel controles = new JPanel();
        JButton btnInsertar = new JButton("Insertar");
        JButton btnEliminar = new JButton("Eliminar");

        controles.add(new JLabel("Valor:"));
        controles.add(txtDato);
        controles.add(btnInsertar);
        controles.add(btnEliminar);

        // Lienzo de dibujo
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (arbol.raiz != null) {
                    dibujarNodo(g, getWidth() / 2, 50, arbol.raiz, getWidth() / 4);
                }
            }
        };

        btnInsertar.addActionListener(e -> {
            arbol.insertar(Integer.parseInt(txtDato.getText()));
            canvas.repaint();
        });

        btnEliminar.addActionListener(e -> {
            arbol.eliminar(Integer.parseInt(txtDato.getText()));
            canvas.repaint();
        });

        add(controles, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
    }

    private void dibujarNodo(Graphics g, int x, int y, Nodo nodo, int offset) {
        g.setColor(Color.LIGHT_GRAY);
        if (nodo.izq != null) {
            g.drawLine(x, y, x - offset, y + 50);
            dibujarNodo(g, x - offset, y + 50, nodo.izq, offset / 2);
        }
        if (nodo.der != null) {
            g.drawLine(x, y, x + offset, y + 50);
            dibujarNodo(g, x + offset, y + 50, nodo.der, offset / 2);
        }

        g.setColor(Color.WHITE);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(String.valueOf(nodo.valor), x - 7, y + 5);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VisualizadorABB().setVisible(true));
    }
}