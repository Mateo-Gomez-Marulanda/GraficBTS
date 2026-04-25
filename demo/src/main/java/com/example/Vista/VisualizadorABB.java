package com.example.Vista;

import javax.swing.*;

import com.example.Model.ArbolBase.Node;
import com.example.Model.ArbolBase.Tree;

import java.awt.*;

public class VisualizadorABB extends JFrame {
    private Tree<Integer> arbol = new Tree<>();
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
        JButton btnBuscar = new JButton("Buscar");
        JButton btnInOrder = new JButton("InOrder");
        JButton btnPreOrder = new JButton("PreOrder");
        JButton btnPostOrder = new JButton("PostOrder");

        controles.add(new JLabel("Valor:"));
        controles.add(txtDato);
        controles.add(btnInsertar);
        controles.add(btnEliminar);
        controles.add(btnBuscar);
        controles.add(btnInOrder);
        controles.add(btnPreOrder);
        controles.add(btnPostOrder);

        // Lienzo de dibujo
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (arbol.root() != null) {
                    dibujarNodo(g, getWidth() / 2, 50, arbol.root(), getWidth() / 4);
                }
            }
        };

        btnInsertar.addActionListener(e -> {
            try {
                int valor = Integer.parseInt(txtDato.getText());
                boolean insertado = arbol.put(valor);

                if (insertado) {
                    canvas.repaint();
                    txtDato.setText("");
                    JOptionPane.showMessageDialog(this, "Valor " + valor + " insertado correctamente", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El valor " + valor + " ya existe en el árbol",
                            "Valor Duplicado", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminar.addActionListener(e -> {
            try {
                int valor = Integer.parseInt(txtDato.getText());
                boolean eliminado = arbol.remove(valor);

                if (eliminado) {
                    canvas.repaint();
                    txtDato.setText("");
                    JOptionPane.showMessageDialog(this, "Valor " + valor + " eliminado correctamente", "Éxito",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El valor " + valor + " no existe en el árbol",
                            "Valor No Encontrado", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnBuscar.addActionListener(e -> {
            try {
                int valor = Integer.parseInt(txtDato.getText());
                boolean encontrado = arbol.binarySearch(valor);

                if (encontrado) {
                    JOptionPane.showMessageDialog(this, "El valor " + valor + " SÍ existe en el árbol", "Valor Encontrado",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "El valor " + valor + " NO existe en el árbol",
                            "Valor No Encontrado", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnInOrder.addActionListener(e -> {
            String resultado = arbol.inOrder();
            if (resultado == null) {
                JOptionPane.showMessageDialog(this, "InOrder no se pudo ejecutar, árbol vacío", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Recorrido InOrder:\n\n" + resultado, "InOrder",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnPreOrder.addActionListener(e -> {
            String resultado = arbol.preOrder();
            if (resultado == null) {
                JOptionPane.showMessageDialog(this, "PreOrder no se pudo ejecutar, árbol vacío", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Recorrido PreOrder:\n\n" + resultado, "PreOrder",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnPostOrder.addActionListener(e -> {
            String resultado = arbol.postOrder();
            if (resultado == null) {
                JOptionPane.showMessageDialog(this, "PostOrder no se pudo ejecutar, árbol vacío", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Recorrido PostOrder:\n\n" + resultado, "PostOrder",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        add(controles, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
    }

    private void dibujarNodo(Graphics g, int x, int y, Node<Integer> nodo, int offset) {
        g.setColor(Color.LIGHT_GRAY);
        if (nodo.getLeft() != null) {
            g.drawLine(x, y, x - offset, y + 50);
            dibujarNodo(g, x - offset, y + 50, nodo.getLeft(), offset / 2);
        }
        if (nodo.getRight() != null) {
            g.drawLine(x, y, x + offset, y + 50);
            dibujarNodo(g, x + offset, y + 50, nodo.getRight(), offset / 2);
        }

        g.setColor(Color.WHITE);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(String.valueOf(nodo.getValue()), x - 7, y + 5);
    }
}