package com.example;

import javax.swing.SwingUtilities;

import com.example.Vista.VisualizadorABB;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VisualizadorABB().setVisible(true));
    }
}
