package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Clientes.Cliente;
import Galeria.Galeria;

import java.awt.*;
import java.util.ArrayList;

public class MenuAdmin extends JFrame {
    private JPanel panelDerecho;

    public MenuAdmin() {
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
        panelIzquierdo.setLayout(new GridLayout(7, 1, 10, 10));  // Cambiado a 7 filas para el nuevo botón
        panelIzquierdo.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Crear los botones
        JButton validarUsuarioBtn = new JButton("Validar Usuario");
        JButton agregarPiezasBtn = new JButton("Agregar Piezas a Inventario");
        JButton eliminarInventarioBtn = new JButton("Eliminar Inventario");
        JButton consultarHistorialPiezaBtn = new JButton("Consultar Historial Pieza");
        JButton consultarHistorialArtistaBtn = new JButton("Consultar Historial Artista");
        JButton calendarioVentasBtn = new JButton("Calendario de Ventas");
        JButton salirBtn = new JButton("Salir");

        // Agregar los botones al panel izquierdo
        panelIzquierdo.add(validarUsuarioBtn);
        panelIzquierdo.add(agregarPiezasBtn);
        panelIzquierdo.add(eliminarInventarioBtn);
        panelIzquierdo.add(consultarHistorialPiezaBtn);
        panelIzquierdo.add(consultarHistorialArtistaBtn);
        panelIzquierdo.add(calendarioVentasBtn);
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
        panelDerecho.add(crearPanelCalendarioVentas(), "CalendarioVentas");

        // Añadir ActionListeners a los botones
        validarUsuarioBtn.addActionListener(e -> mostrarPanel("ValidarUsuario"));
        agregarPiezasBtn.addActionListener(e -> mostrarPanel("AgregarPiezas"));
        eliminarInventarioBtn.addActionListener(e -> mostrarPanel("EliminarInventario"));
        consultarHistorialPiezaBtn.addActionListener(e -> mostrarPanel("ConsultarHistorialPieza"));
        consultarHistorialArtistaBtn.addActionListener(e -> mostrarPanel("ConsultarHistorialArtista"));
        calendarioVentasBtn.addActionListener(e -> mostrarPanel("CalendarioVentas"));
        salirBtn.addActionListener(e -> System.exit(0));

        // Crear el JSplitPane para dividir la ventana en dos partes
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, panelDerecho);
        splitPane.setDividerLocation(200);

        // Agregar el split pane a la ventana
        this.add(splitPane);
    }



    // se empieza a modificar el contenido a la derecha de los paneles 
    private void mostrarPanel(String nombrePanel) {
        CardLayout cl = (CardLayout) (panelDerecho.getLayout());
        cl.show(panelDerecho, nombrePanel);
    }

    private JPanel crearPanelValidarUsuario() {
    ArrayList<Cliente>   listaClientes= Galeria.getlistaClientes();
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());

    // Lista de usuarios
    DefaultListModel<String> modeloLista = new DefaultListModel<>();
    JList<String> listaUsuarios = new JList<>(modeloLista);
    JScrollPane scrollPane = new JScrollPane(listaUsuarios);

    for (Cliente cliente : listaClientes) {
        modeloLista.addElement(cliente.getContacto()); 
    }

    panel.add(scrollPane, BorderLayout.CENTER);

    // Botón para validar clientes
    JButton validarClientesButton = new JButton("Validar Clientes");
    validarClientesButton.addActionListener(e -> {
        // Iterar sobre la lista de clientes y cambiar el estado de validado a true
        for (Cliente cliente : listaClientes) {
            cliente.setValidacion(true);
        }
        JOptionPane.showMessageDialog(MenuAdmin.this, "Todos los clientes han sido validados.");
    });
    panel.add(validarClientesButton, BorderLayout.SOUTH);

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

    private JPanel crearPanelCalendarioVentas() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Panel de Calendario de Ventas"));
        // Agregar los componentes necesarios para el calendario de ventas
        return panel;
    }

    public static void main(String[] args) {
        MenuAdmin admin = new MenuAdmin();
        admin.setVisible(true);
    }
}