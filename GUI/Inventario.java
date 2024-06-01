package GUI;

import javax.swing.*;
import java.awt.*;

public class Inventario extends JPanel {
    public Inventario(MainApp mainApp) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Estas son las piezas para comprar", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        String[] columnNames = {"Pieza", "Precio"};
        Object[][] data = {
                {"Pieza 1", "$2000"},
                {"Pieza 2", "$3000"},
                {"Pieza 3", "$4000"}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                mainApp.showFrame("Frame11");
            }
        });
    }
}