package GUI;

import javax.swing.*;
import java.awt.*;

public class Frame9 extends JPanel {
    public Frame9(MainApp mainApp) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Detalle de la Pieza", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JLabel detailLabel = new JLabel("Artista: Pepe Grillo\nCódigo de Pieza: #001\nPrecio: $2000\nTamaño: 20x30\nFecha: 1970-02-20", SwingConstants.CENTER);
        add(detailLabel, BorderLayout.CENTER);

        JButton buyButton = new JButton("Comprar");
        buyButton.addActionListener(e -> mainApp.showFrame("Frame10"));
        add(buyButton, BorderLayout.SOUTH);
    }
}