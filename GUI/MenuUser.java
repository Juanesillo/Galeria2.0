package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Galeria.Galeria;
import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

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
    panel.setLayout(new BorderLayout());

    // Panel superior para ingresar el nombre de la pieza
    JTextField nombrePiezaTextField = new JTextField(20);
    JButton comprarButton = new JButton("Comprar");
    JPanel panelNombre = new JPanel();
    panelNombre.add(new JLabel("Nombre de la pieza: "));
    panelNombre.add(nombrePiezaTextField);
    panelNombre.add(comprarButton);

    // Panel inferior para mostrar las piezas disponibles
    JTextArea piezasDisponiblesTextArea = new JTextArea(10, 30);
    piezasDisponiblesTextArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(piezasDisponiblesTextArea);
    JPanel panelPiezasDisponibles = new JPanel();
    panelPiezasDisponibles.setLayout(new BorderLayout());
    panelPiezasDisponibles.add(new JLabel("Piezas disponibles:"), BorderLayout.NORTH);
    panelPiezasDisponibles.add(scrollPane, BorderLayout.CENTER);

    // Acción al presionar el botón de comprar
    comprarButton.addActionListener(e -> {
        String nombrePieza = nombrePiezaTextField.getText();
        if (Galeria.listadoInventario().containsKey(nombrePieza)) {
            Galeria.comprar(nombrePieza);
            JOptionPane.showMessageDialog(MenuUser.this, "Pieza comprada: " + nombrePieza);
        } else {
            JOptionPane.showMessageDialog(MenuUser.this, "Pieza no encontrada.");
        }
        nombrePiezaTextField.setText(""); // Limpiar el campo de texto después de la compra
    });

    // Llenar el JTextArea con las piezas disponibles
    StringBuilder piezasTexto = new StringBuilder();
    for (Map.Entry<String, Pieza> entry : Galeria.listadoInventario().entrySet()) {
        piezasTexto.append(entry.getKey()).append(": ").append(entry.getValue().toString()).append("\n");
    }
    piezasDisponiblesTextArea.setText(piezasTexto.toString());

    // Agregar los paneles al panel principal
    panel.add(panelNombre, BorderLayout.NORTH);
    panel.add(panelPiezasDisponibles, BorderLayout.CENTER);

    return panel;
    }

    private JPanel crearPanelRegistrarPieza() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
    
        // Crear los campos de texto y etiquetas
        JTextField tituloTextField = new JTextField(20);
        JTextField fechaTextField = new JTextField(20);
        JTextField lugarCreacionTextField = new JTextField(20);
        JTextField precioTextField = new JTextField(20);
        JTextField disponibleTextField = new JTextField(20);
        JTextField estadoTextField = new JTextField(20);
        JTextField autorTextField = new JTextField(20);
    
        JPanel panelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
        panelCampos.add(new JLabel("Título de la pieza:"));
        panelCampos.add(tituloTextField);
        panelCampos.add(new JLabel("Fecha de creación (Year/Day/Month):"));
        panelCampos.add(fechaTextField);
        panelCampos.add(new JLabel("Lugar de creación:"));
        panelCampos.add(lugarCreacionTextField);
        panelCampos.add(new JLabel("Precio:"));
        panelCampos.add(precioTextField);
        panelCampos.add(new JLabel("Disponible para subasta (true/false):"));
        panelCampos.add(disponibleTextField);
        panelCampos.add(new JLabel("Estado:"));
        panelCampos.add(estadoTextField);
        panelCampos.add(new JLabel("Autor:"));
        panelCampos.add(autorTextField);
    
        // Panel para el botón de registrar pieza
        JButton registrarPiezaButton = new JButton("Registrar Pieza");
        JPanel panelBoton = new JPanel();
        panelBoton.add(registrarPiezaButton);
    
        // Acción al presionar el botón de registrar pieza
        registrarPiezaButton.addActionListener(e -> {
            String titulo = tituloTextField.getText();
            String fecha = fechaTextField.getText();
            String lugarCreacion = lugarCreacionTextField.getText();
            Integer precio = Integer.parseInt(precioTextField.getText());
            Boolean disponible = Boolean.parseBoolean(disponibleTextField.getText());
            String estado = estadoTextField.getText();
            String autor = autorTextField.getText();
    
            // Crear la pieza y enviar la solicitud
            Pieza pieza = new Pieza(titulo, fecha, lugarCreacion, precio, disponible, estado, autor);
            Galeria.SolicitudPieza(titulo, pieza);
    
            JOptionPane.showMessageDialog(MenuUser.this, "Pieza registrada: " + titulo);
    
            // Limpiar los campos de texto después del registro
            tituloTextField.setText("");
            fechaTextField.setText("");
            lugarCreacionTextField.setText("");
            precioTextField.setText("");
            disponibleTextField.setText("");
            estadoTextField.setText("");
            autorTextField.setText("");
        });
    
        // Agregar los paneles al panel principal
        panel.add(panelCampos, BorderLayout.CENTER);
        panel.add(panelBoton, BorderLayout.SOUTH);
    
        return panel;
    }

    private JPanel crearPanelConsultarHistorialPieza() {
      JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
    
        // Panel para ingresar el nombre de la pieza
        JTextField nombrePiezaTextField = new JTextField(20);
        JPanel panelNombrePieza = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNombrePieza.add(new JLabel("Nombre de la pieza: "));
        panelNombrePieza.add(nombrePiezaTextField);
    
        // Panel para el botón de consulta
        JButton consultarHistorialButton = new JButton("Consultar Historial");
        JPanel panelBoton = new JPanel();
        panelBoton.add(consultarHistorialButton);
    
        // Panel para mostrar el historial
        JTextArea historialTextArea = new JTextArea(10, 30);
        historialTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historialTextArea);
    
        // Acción al presionar el botón de consulta
        consultarHistorialButton.addActionListener(e -> {
            String nombrePieza = nombrePiezaTextField.getText();
            
            ArrayList<Object> historial = Galeria.historialPieza(nombrePieza);
            if (historial != null && !historial.isEmpty()) {
                historialTextArea.setText(""); // Limpiar el área de texto
                for (Object item : historial) {
                    historialTextArea.append(item.toString() + "\n");
                }
            } else {
                historialTextArea.setText("La pieza no tiene historial registrado.");
            }
        });
    
        // Panel para organizar los componentes
        JPanel panelConsulta = new JPanel();
        panelConsulta.setLayout(new BorderLayout());
        panelConsulta.add(panelNombrePieza, BorderLayout.NORTH);
        panelConsulta.add(panelBoton, BorderLayout.CENTER);
        panelConsulta.add(scrollPane, BorderLayout.SOUTH);
    
        panel.add(panelConsulta, BorderLayout.CENTER);
    
        return panel;
    }

    private JPanel crearPanelConsultarHistorialArtista() {
        JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());

    // Panel para ingresar el nombre del artista
    JTextField nombreArtistaTextField = new JTextField(20);
    JPanel panelNombreArtista = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panelNombreArtista.add(new JLabel("Nombre del artista: "));
    panelNombreArtista.add(nombreArtistaTextField);

    // Panel para el botón de consulta
    JButton consultarHistorialButton = new JButton("Consultar Historial");
    JPanel panelBoton = new JPanel();
    panelBoton.add(consultarHistorialButton);

    // Panel para mostrar el historial
    JTextArea historialTextArea = new JTextArea(10, 30);
    historialTextArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(historialTextArea);

    // Acción al presionar el botón de consulta
    consultarHistorialButton.addActionListener(e -> {
        String nombreArtista = nombreArtistaTextField.getText();
        //agregar al historial antes de imprimirlo 
        Inventario.AgregarHistorialArtista(nombreArtista);
        ArrayList<Pieza> historial = Galeria.historialArtista(nombreArtista);
        if (historial != null && !historial.isEmpty()) {
            historialTextArea.setText(""); // Limpiar el área de texto
            for (Object item : historial) {
                historialTextArea.append(item.toString() + "\n");
            }
        } else {
            historialTextArea.setText("El artista no tiene historial registrado.");
        }
    });

    // Panel para organizar los componentes
    JPanel panelConsulta = new JPanel();
    panelConsulta.setLayout(new BorderLayout());
    panelConsulta.add(panelNombreArtista, BorderLayout.NORTH);
    panelConsulta.add(panelBoton, BorderLayout.CENTER);
    panelConsulta.add(scrollPane, BorderLayout.SOUTH);

    panel.add(panelConsulta, BorderLayout.CENTER);

    return panel;
    }

    public static void main(String[] args) {
        MenuUser user = new MenuUser();
        user.setVisible(true);
    }
}