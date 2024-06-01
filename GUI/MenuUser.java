package GUI;
import javax.swing.*;
import java.awt.*;

public class MenuUser extends JPanel {
    public MenuUser(MainApp mainApp) {
        setLayout(new GridLayout(4, 1));

        JButton buyButton = new JButton("Comprar una pieza");
        JButton registerButton = new JButton("Registrar una pieza");
        JButton historyPieceButton = new JButton("Consultar Histórico de Piezas");
        JButton historyArtistButton = new JButton("Consultar Histórico de Artistas");

        buyButton.addActionListener(e -> mainApp.showFrame("Frame8"));
        registerButton.addActionListener(e -> mainApp.showFrame("Frame7"));
        historyPieceButton.addActionListener(e -> mainApp.showFrame("Frame9"));
        historyArtistButton.addActionListener(e -> mainApp.showFrame("Frame12"));

        add(buyButton);
        add(registerButton);
        add(historyPieceButton);
        add(historyArtistButton);
    }
}
