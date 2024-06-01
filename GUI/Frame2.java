package GUI;

import javax.swing.*;
import java.awt.*;

public class Frame2 extends JPanel{

	public Frame2(MainApp mainApp) {
        setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(e -> mainApp.showFrame("Frame4"));

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginButton);
    }
}
