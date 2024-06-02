package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuUser extends JFrame {
    private JPanel panelDerecho;

    public MenuUser() {
        super("Administrador Galeria");

        // Establecer el tamaño de la ventana
        this.setSize(800, 600);

        // Terminar el programa cuando la GUI se cierre
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Ejecutar la GUI en la mitad de la pantalla
        this.setLocationRelativeTo(null);

        // Llamar al método para inicializar y agregar componentes
        iniciar();
    }

    private void iniciar() {
        // Crear el panel izquierdo con los botones
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(5, 1, 10, 10));
        panelIzquierdo.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Crear los botones
        JButton comprarPiezaBtn = new JButton("Comprar una pieza");
        JButton registrarPiezaBtn = new JButton("Registrar una pieza");
        JButton consultarHistorialPiezaBtn = new JButton("Consultar Historial de una pieza");
        JButton consultarHistorialArtistaBtn = new JButton("Consultar Historial de un artista");
        JButton salirBtn = new JButton("Salir");

        // Agregar los botones al panel izquierdo
        panelIzquierdo.add(comprarPiezaBtn);
        panelIzquierdo.add(registrarPiezaBtn);
        panelIzquierdo.add(consultarHistorialPiezaBtn);
        panelIzquierdo.add(consultarHistorialArtistaBtn);
        panelIzquierdo.add(salirBtn);

        // Crear el panel derecho donde se mostrarán los distintos paneles
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new CardLayout());

        // Agregar paneles a la derecha
        panelDerecho.add(new JPanel(), "Vacio");
        panelDerecho.add(crearPanelComprarPieza(), "ComprarPieza");
        panelDerecho.add(crearPanelRegistrarPieza(), "RegistrarPieza");
        panelDerecho.add(crearPanelConsultarHistorialPieza(), "ConsultarHistorialPieza");
        panelDerecho.add(crearPanelConsultarHistorialArtista(), "ConsultarHistorialArtista");

        // Añadir ActionListeners a los botones
        comprarPiezaBtn.addActionListener(e -> mostrarPanel("ComprarPieza"));
        registrarPiezaBtn.addActionListener(e -> mostrarPanel("RegistrarPieza"));
        consultarHistorialPiezaBtn.addActionListener(e -> mostrarPanel("ConsultarHistorialPieza"));
        consultarHistorialArtistaBtn.addActionListener(e -> mostrarPanel("ConsultarHistorialArtista"));
        salirBtn.addActionListener(e -> {
            MenuUser.this.dispose();
            Login login = new Login();
            login.setVisible(true);
        });

        // Crear el JSplitPane para dividir la ventana en dos partes
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, panelDerecho);
        splitPane.setDividerLocation(200);

        // Agregar el split pane a la ventana
        this.add(splitPane);
    }

    private void mostrarPanel(String nombrePanel) {
        CardLayout cl = (CardLayout) (panelDerecho.getLayout());
        cl.show(panelDerecho, nombrePanel);
    }

    private JPanel crearPanelComprarPieza() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Comprar una pieza"));
        // Agregar los componentes necesarios para comprar una pieza
        return panel;
    }

    private JPanel crearPanelRegistrarPieza() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Registrar una pieza"));
        // Agregar los componentes necesarios para registrar una pieza
        return panel;
    }

    private JPanel crearPanelConsultarHistorialPieza() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Consultar Historial de una pieza"));
        // Agregar los componentes necesarios para consultar historial de una pieza
        return panel;
    }

    private JPanel crearPanelConsultarHistorialArtista() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Consultar Historial de un artista"));
        // Agregar los componentes necesarios para consultar historial de un artista
        return panel;
    }

    public static void main(String[] args) {
        MenuUser user = new MenuUser();
        user.setVisible(true);
    }
}