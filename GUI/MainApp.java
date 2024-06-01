package GUI;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame{
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Pinacoteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Adding all frames to the main panel
        mainPanel.add(new Login(this), "Frame1");
        mainPanel.add(new Frame2(this), "Frame2");
        mainPanel.add(new Frame3(this), "Frame3");
        mainPanel.add(new Frame4(this), "Frame4");
        mainPanel.add(new Frame5(this), "Frame5");
        mainPanel.add(new Frame6(this), "Frame6");
        mainPanel.add(new Frame7(this), "Frame7");
        mainPanel.add(new Frame8(this), "Frame8");
        mainPanel.add(new Frame9(this), "Frame9");
        mainPanel.add(new Frame10(this), "Frame10");
        mainPanel.add(new Frame11(this), "Frame11");
        mainPanel.add(new Frame12(this), "Frame12");

        frame.add(mainPanel);
        frame.setVisible(true);

        showFrame("Frame1");
    }

    public void showFrame(String frameName) {
        cardLayout.show(mainPanel, frameName);
    }
}
