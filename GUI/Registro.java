package GUI;

import javax.swing.*;
import java.awt.*;

public class Registro extends JPanel {
    public Registro(MainApp mainApp) {
        setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField();
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        JLabel emailLabel = new JLabel("Correo:");
        JTextField emailField = new JTextField();
        JButton registerButton = new JButton("Registrar");

        registerButton.addActionListener(e -> mainApp.showFrame("Frame1"));

        add(nameLabel);
        add(nameField);
        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(emailLabel);
        add(emailField);
        add(registerButton);
    }
}


