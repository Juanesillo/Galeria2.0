package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Galeria.Galeria;
import InventariosySubasta.Pieza;

import Trabajadores.Operador;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class MenuOperador extends JFrame {
    private JPanel panelDerecho;

    public MenuOperador() {
        super("Operador Galería");

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
        JButton iniciarSubastaBtn = new JButton("Iniciar subasta");
        JButton registrarBtn = new JButton("Registrar");
        JButton obtenerGanadoresBtn = new JButton("Obtener ganadores");
        JButton historialPiezaBtn = new JButton("Historial pieza");
        JButton historialArtistaBtn = new JButton("Historial artista");
        JButton salirBtn = new JButton("Salir");

        // Agregar los botones al panel izquierdo
        panelIzquierdo.add(iniciarSubastaBtn);
        panelIzquierdo.add(registrarBtn);
        panelIzquierdo.add(obtenerGanadoresBtn);
        panelIzquierdo.add(historialPiezaBtn);
        panelIzquierdo.add(historialArtistaBtn);
        panelIzquierdo.add(salirBtn);

        // Crear el panel derecho donde se mostrarán los distintos paneles
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new CardLayout());

        // Agregar paneles a la derecha
        panelDerecho.add(new JPanel(), "Vacio");
        panelDerecho.add(crearPanelIniciarSubasta(), "IniciarSubasta");
        panelDerecho.add(crearPanelRegistrar(), "Registrar");
        panelDerecho.add(crearPanelObtenerGanadores(), "ObtenerGanadores");
        panelDerecho.add(crearPanelHistorialPieza(), "HistorialPieza");
        panelDerecho.add(crearPanelHistorialArtista(), "HistorialArtista");

        // Añadir ActionListeners a los botones
        iniciarSubastaBtn.addActionListener(e -> mostrarPanel("IniciarSubasta"));
        registrarBtn.addActionListener(e -> mostrarPanel("Registrar"));
        obtenerGanadoresBtn.addActionListener(e -> mostrarPanel("ObtenerGanadores"));
        historialPiezaBtn.addActionListener(e -> mostrarPanel("HistorialPieza"));
        historialArtistaBtn.addActionListener(e -> mostrarPanel("HistorialArtista"));
        salirBtn.addActionListener(e -> {
            MenuOperador.this.dispose();
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

    private JPanel crearPanelIniciarSubasta() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        JButton iniciarSubastaBtn = new JButton("Iniciar Subasta");
        iniciarSubastaBtn.addActionListener(e -> {
            Operador.iniciarLaSubasta();
            JOptionPane.showMessageDialog(MenuOperador.this, "Subasta Iniciada");
        });

        panel.add(iniciarSubastaBtn, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearPanelRegistrar() {
        JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    
    // Panel para ingresar el nombre del cliente y la puja
    JTextField nombreClienteTextField = new JTextField(20);
    JTextField pujaTextField = new JTextField(20);
    JPanel panelNombreYPuja = new JPanel(new GridLayout(2, 2, 5, 5));
    panelNombreYPuja.add(new JLabel("Nombre del cliente: "));
    panelNombreYPuja.add(nombreClienteTextField);
    panelNombreYPuja.add(new JLabel("Puja: "));
    panelNombreYPuja.add(pujaTextField);
    
    // Panel para el botón de registro
    JButton registrarButton = new JButton("Registrar");
    JPanel panelBoton = new JPanel();
    panelBoton.add(registrarButton);
    
    // Acción al presionar el botón de registro
    registrarButton.addActionListener(e -> {
        String nombreCliente = nombreClienteTextField.getText();
        Integer puja = Integer.parseInt(pujaTextField.getText());
        
        Operador.registrarSubasta(nombreCliente, puja);
        // Limpiar los campos de texto después del registro
        nombreClienteTextField.setText("");
        pujaTextField.setText("");
    });
    
    // Panel para organizar los componentes
    JPanel panelRegistro = new JPanel();
    panelRegistro.setLayout(new BorderLayout());
    panelRegistro.add(panelNombreYPuja, BorderLayout.CENTER);
    panelRegistro.add(panelBoton, BorderLayout.SOUTH);
    
    panel.add(panelRegistro, BorderLayout.CENTER);
    
    return panel;
    }

    private JPanel crearPanelObtenerGanadores() {
        JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());

    // Panel para mostrar los ganadores
    JTextArea ganadoresTextArea = new JTextArea(10, 30);
    ganadoresTextArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(ganadoresTextArea);
    panel.add(scrollPane, BorderLayout.CENTER);

    // Panel para el botón de registrar ganadores
    JButton registrarGanadoresBtn = new JButton("Registrar Ganadores");
    JPanel panelBoton = new JPanel();
    panelBoton.add(registrarGanadoresBtn);
    panel.add(panelBoton, BorderLayout.SOUTH);

    // Acción al presionar el botón de registrar ganadores
    registrarGanadoresBtn.addActionListener(e -> {
        Operador.registroGanador();
        mostrarGanadores(ganadoresTextArea);
    });

    return panel;
    }

    private void mostrarGanadores(JTextArea ganadoresTextArea) {
    StringBuilder sb = new StringBuilder();
    sb.append("Ganadores:\n");

    for (Map.Entry<String, Pieza> entry : Operador.ObtenerGanador().entrySet()) {
        String nombreGanador = entry.getKey();
        Pieza piezaGanada = entry.getValue();
        sb.append(nombreGanador).append(": ").append(piezaGanada.toString()).append("\n");
    }

    ganadoresTextArea.setText(sb.toString());
}



    private JPanel crearPanelHistorialPieza() {
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

    private JPanel crearPanelHistorialArtista() {
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
            InventariosySubasta.Inventario.AgregarHistorialArtista(nombreArtista);
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
        MenuOperador operador = new MenuOperador();
        operador.setVisible(true);
    }
}
