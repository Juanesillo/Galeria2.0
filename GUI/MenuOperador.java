package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class MenuOperador extends JFrame {
    private JPanel panelDerecho;
    public MenuOperador() {
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
        panelIzquierdo.setLayout(new GridLayout(6, 1, 10, 10));
        panelIzquierdo.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Crear los botones
        JButton validarUsuarioBtn = new JButton("Validar Usuario");
        JButton agregarPiezasBtn = new JButton("Agregar Piezas a Inventario");
        JButton eliminarInventarioBtn = new JButton("Eliminar Inventario");
        JButton consultarHistorialPiezaBtn = new JButton("Consultar Historial Pieza");
        JButton consultarHistorialArtistaBtn = new JButton("Consultar Historial Artista");
        JButton salirBtn = new JButton("Salir");

        // Agregar los botones al panel izquierdo
        panelIzquierdo.add(validarUsuarioBtn);
        panelIzquierdo.add(agregarPiezasBtn);
        panelIzquierdo.add(eliminarInventarioBtn);
        panelIzquierdo.add(consultarHistorialPiezaBtn);
        panelIzquierdo.add(consultarHistorialArtistaBtn);
        panelIzquierdo.add(salirBtn);

        // Crear el panel derecho donde se mostrarán los distintos paneles
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new CardLayout());

        // Agregar paneles a la derecha
        panelDerecho.add(new JPanel(), "Vacio");
        panelDerecho.add(crearPanelValidarUsuario(), "ValidarUsuario");
        panelDerecho.add(crearPanelAgregarPiezas(), "AgregarPiezas");
        panelDerecho.add(crearPanelEliminarInventario(), "EliminarInventario");
        panelDerecho.add(crearPanelConsultarHistorialPieza(), "ConsultarHistorialPieza");
        panelDerecho.add(crearPanelConsultarHistorialArtista(), "ConsultarHistorialArtista");

        // Añadir ActionListeners a los botones
        validarUsuarioBtn.addActionListener(e -> mostrarPanel("ValidarUsuario"));
        agregarPiezasBtn.addActionListener(e -> mostrarPanel("AgregarPiezas"));
        eliminarInventarioBtn.addActionListener(e -> mostrarPanel("EliminarInventario"));
        consultarHistorialPiezaBtn.addActionListener(e -> mostrarPanel("ConsultarHistorialPieza"));
        consultarHistorialArtistaBtn.addActionListener(e -> mostrarPanel("ConsultarHistorialArtista"));
        salirBtn.addActionListener(e -> System.exit(0));

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

    private JPanel crearPanelValidarUsuario() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Validar Usuario"));
        // Agregar los componentes necesarios para validar usuario
        return panel;
    }

    private JPanel crearPanelAgregarPiezas() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Agregar Piezas a Inventario"));
        // Agregar los componentes necesarios para agregar piezas a inventario
        return panel;
    }

    private JPanel crearPanelEliminarInventario() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Eliminar Inventario"));
        // Agregar los componentes necesarios para eliminar inventario
        return panel;
    }

    private JPanel crearPanelConsultarHistorialPieza() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Consultar Historial Pieza"));
        // Agregar los componentes necesarios para consultar historial de pieza
        return panel;
    }

    private JPanel crearPanelConsultarHistorialArtista() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Consultar Historial Artista"));
        // Agregar los componentes necesarios para consultar historial de artista
        return panel;
    }

    public static void main(String[] args) {
        MenuOperador operador = new MenuOperador();
        operador.setVisible(true);
    }
}
