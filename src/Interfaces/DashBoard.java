package src.Interfaces;

import javax.swing.*;
import java.awt.*;

public class DashBoard extends javax.swing.JFrame {

    private JFrame frame;

    public DashBoard() {
        // Initialize frame
        frame = new JFrame("Student Management System - Dashboard");

        // Set frame layout
        frame.setLayout(new BorderLayout());

        // Sidebar panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(new Color(42, 87, 141));

        // Buttons for navigation
        JButton studentButton = new JButton("Manage Students");
        JButton courseButton = new JButton("Manage Courses");
        JButton reportsButton = new JButton("Reports");
        JButton logoutButton = new JButton("Logout");

        // Add buttons to sidebar
        sidebarPanel.add(studentButton);
        sidebarPanel.add(courseButton);
        sidebarPanel.add(reportsButton);
        sidebarPanel.add(logoutButton);

        // Add sidebar to frame (left side)
        frame.add(sidebarPanel, BorderLayout.WEST);

        // Content area for dashboard info
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);

        // Title for dashboard
        JLabel titleLabel = new JLabel("Welcome to the Dashboard!", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Add title to content panel
        contentPanel.add(titleLabel);

        // Add content panel to frame (center)
        frame.add(contentPanel, BorderLayout.CENTER);

        // Set frame properties
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create instance of Dashboard to run
        new DashBoard();
    }
}
