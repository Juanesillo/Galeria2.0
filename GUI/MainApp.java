package GUI;

import javax.swing.*;
import java.awt.*;

public class MainApp {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public static void main(String[] args) {
       


        SwingUtilities.invokeLater(new Runnable(){
            // Esta linea de codigo ejecuta LoginGui para que aparezca en pantalla
            @Override
            public void run(){
            new  Inicio().setVisible(true);



               
        }
    });
    }

   

    public void showFrame(String frameName) {
        cardLayout.show(mainPanel, frameName);
    }
}
