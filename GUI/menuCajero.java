package GUI;

import javax.swing.*;
import java.awt.*;

public class menuCajero extends JPanel {
    public menuCajero() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Detalle de la Pieza", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JLabel pieceDetailLabel = new JLabel("<html>Artista: Pepe Grillo<br/>Código de Pieza: #001<br/>Precio: $2000<br/>Tamaño: 20x30<br/>Fecha: 1970-02-20</html>", SwingConstants.CENTER);
        add(pieceDetailLabel, BorderLayout.CENTER);

        JButton buyButton = new JButton("Comprar");
       
        add(buyButton, BorderLayout.SOUTH);

        JButton artistDetailButton = new JButton("Ver detalles del artista");

        add(artistDetailButton, BorderLayout.SOUTH);
    }
}
