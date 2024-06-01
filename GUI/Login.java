package GUI;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel{

	public Login() {
        setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");

       

        add(userLabel);
        add(userField);
        add(passLabel);
        add(passField);
        add(loginButton);
    }
}
