package src.Interfaces;
import java.sql.DriverManager;
import src.DataBase.DataBaseConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

public class LoginForm extends javax.swing.JFrame {
    private JTextField UsernameField;
    private JPasswordField PasswordField;
    private JPanel MainPanel;
    private JLabel Label1;
    private JLabel Label2;
    private JButton button1;

    // Database connection details
    private String url = "jdbc:mysql://shawa.com.tr:3306/shawacom_SMS?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private String dbUser = "shawacom_heso";
    private String dbPassword = "Hes0@981";

    public LoginForm() {
        // Setup JFrame
        setContentPane(MainPanel);
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        // ActionListener for login button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = UsernameField.getText();
                String password = new String(PasswordField.getPassword()); // Get the password as string

                if (username.trim().equals("") || password.trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Username or Password is Empty");
                } else {
                    // Perform database connection and validation
                    try {
                        Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
                        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setString(1, username);
                        ps.setString(2, password);

                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            // If a matching user is found
                           // JOptionPane.showMessageDialog(null, "Login successful!");
                            dispose();

                           new DashBoard();
                            // Redirect to next form or dashoard (you can add code for that)
                        } else {
                            // If no matching user found
                            JOptionPane.showMessageDialog(null, "Invalid username or password.");
                        }
                        // Close resources
                        rs.close();
                        ps.close();
                        con.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Database connection failed: " + ex.getMessage());
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
