package src.Interfaces;

import javax.swing.*;

public class DashBoard extends javax.swing.JFrame {

    public DashBoard() {
        setTitle("DashBoard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        // Create instance of Dashboard to run
        new DashBoard();
    }
}
