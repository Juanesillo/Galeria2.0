package GUI;

import javax.swing.*;
import java.awt.*;

public class MenuOperador extends JPanel {
    public MenuOperador() {
        setLayout(new GridLayout(4, 1));

        JButton buyButton = new JButton("Comprar una pieza");
        JButton registerButton = new JButton("Registrar una pieza");
        JButton historyPieceButton = new JButton("Consultar Histórico de Piezas");
        JButton historyArtistButton = new JButton("Consultar Histórico de Artistas");

        

        add(buyButton);
        add(registerButton);
        add(historyPieceButton);
        add(historyArtistButton);
    }
}
