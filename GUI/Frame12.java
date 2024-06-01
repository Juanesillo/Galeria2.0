package GUI;

import javax.swing.*;
import java.awt.*;

public class Frame12 extends JPanel {
    public Frame12(MainApp mainApp) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Detalle del Artista", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JLabel artistDetailLabel = new JLabel("<html>Nombre: Pepe Grillo<br/>Fecha de nacimiento: 1950-06-15<br/>Estilo: Expresionismo</html>", SwingConstants.CENTER);
        add(artistDetailLabel, BorderLayout.CENTER);

        JButton backButton = new JButton("Volver");
        backButton.addActionListener(e -> mainApp.showFrame("Frame5"));
        add(backButton, BorderLayout.SOUTH);
    }
}