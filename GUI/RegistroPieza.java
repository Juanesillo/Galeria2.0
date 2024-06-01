package GUI;

import javax.swing.*;
import java.awt.*;

public class RegistroPieza extends JPanel {
    public RegistroPieza(MainApp mainApp) {
        setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Nombre:");
        JTextField nameField = new JTextField();
        JLabel artistLabel = new JLabel("Artista:");
        JTextField artistField = new JTextField();
        JLabel dateLabel = new JLabel("Fecha:");
        JTextField dateField = new JTextField();
        JLabel priceLabel = new JLabel("Precio:");
        JTextField priceField = new JTextField();
        JButton registerButton = new JButton("Registrar");

        registerButton.addActionListener(e -> mainApp.showFrame("Frame1"));

        add(nameLabel);
        add(nameField);
        add(artistLabel);
        add(artistField);
        add(dateLabel);
        add(dateField);
        add(priceLabel);
        add(priceField);
        add(registerButton);
    }
}