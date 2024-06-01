package GUI;

import javax.swing.*;
import java.awt.*;


public class Login extends JPanel {
    public Login(MainApp mainApp) {
        // agregar el titulo en la parte superiror 
    JPanel titulo= new JPanel();
    JLabel ltitulo= new JLabel("Bienvenido a Pinacoteca",JLabel.CENTER);
    ltitulo.setFont(new Font("Arial",Font.BOLD,22));
    titulo.add(ltitulo);
    Login.this.add(titulo,BorderLayout.CENTER);

        

        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(e -> mainApp.showFrame("Frame2"));
        add(loginButton, BorderLayout.SOUTH);


    }
}