package GUI;

import javax.swing.*;
import java.awt.*;

public class TipoUser extends JPanel {
    public TipoUser(MainApp mainApp) {
        setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("¿Qué tipo de usuario es usted?", SwingConstants.CENTER);
        JButton userButton = new JButton("Comprador");
        JButton operatorButton = new JButton("Operador");

        userButton.addActionListener(e -> mainApp.showFrame("Frame5"));
        operatorButton.addActionListener(e -> mainApp.showFrame("Frame6"));

        add(label);
        add(userButton);
        add(operatorButton);
    }
}