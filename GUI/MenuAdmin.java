package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Clientes.Cliente;
import Galeria.Galeria;
import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;
import Trabajadores.Administrador;
import Trabajadores.Cajero;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        JButton eliminarInventarioBtn = new JButton("Eliminar pieza del Inventario");
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
        salirBtn.addActionListener(e -> {
            MenuAdmin.this.dispose();
            Login login = new Login();
            login.setVisible(true);
        });

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


    // validar User
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




    // agergar pieza 

    private JPanel crearPanelAgregarPiezas() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    // Lista de piezas
    DefaultListModel<String> modeloLista = new DefaultListModel<>();
    JList<String> listaPiezas = new JList<>(modeloLista);
    JScrollPane scrollPane = new JScrollPane(listaPiezas);

    // Iterar sobre el HashMap y agregar las piezas a la lista
    for (Map.Entry<String, Pieza> entry : Galeria.getsolicituPiez().entrySet()) {
        String key = entry.getKey();
        Pieza value = entry.getValue();
        modeloLista.addElement(key + " - " + value.getTitulo()); 
    }

    panel.add(scrollPane, BorderLayout.CENTER);

    // Botón para agregar piezas al inventario
    JButton agregarPiezasButton = new JButton("Agregar Piezas al Inventario");
    agregarPiezasButton.addActionListener(e -> {
        // Iterar sobre el HashMap y agregar las piezas al inventario
        for (Map.Entry<String, Pieza> entry : Galeria.getsolicituPiez().entrySet()) {
            Pieza pieza = entry.getValue();
            try {
                Administrador.agregarPieza(pieza);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            System.out.println(pieza.getTitulo() + " agregada exitosamente al inventario.");
        }
        JOptionPane.showMessageDialog(MenuAdmin.this, "Todas las piezas han sido agregadas al inventario.");
    });
    panel.add(agregarPiezasButton, BorderLayout.SOUTH);

    return panel;
    }






// eliminar pieza del inventario
    private JPanel crearPanelEliminarInventario() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());

    // Campo de texto para ingresar el nombre de la pieza a eliminar
    JTextField nombrePiezaTextField = new JTextField(20);
    JPanel panelCampoTexto = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panelCampoTexto.add(new JLabel("Nombre de la pieza a eliminar: "));
    panelCampoTexto.add(nombrePiezaTextField);

    // Espacio en blanco para separar el label del campo de texto
    JPanel panelEspacioBlanco = new JPanel();
    panelEspacioBlanco.setPreferredSize(new Dimension(10, 20)); // Ajusta la altura según sea necesario

    panel.add(panelEspacioBlanco, BorderLayout.NORTH); // Agregar espacio en blanco arriba
    panel.add(panelCampoTexto, BorderLayout.CENTER); // Agregar el campo de texto al centro del panel

    // Botón para eliminar la pieza del inventario
    JButton eliminarPiezaButton = new JButton("Eliminar");
    eliminarPiezaButton.addActionListener(e -> {
        String nombrePieza = nombrePiezaTextField.getText();
        if (Galeria.listadoInventario().containsKey(nombrePieza)){

            Administrador.eliminarPieza(nombrePieza);
            JOptionPane.showMessageDialog(MenuAdmin.this, "Pieza " + nombrePieza + " eliminada del inventario.");
        }
        else{
            JOptionPane.showMessageDialog(MenuAdmin.this,"La pieza no se encuentra en el inventario ");
        }
    
        
        nombrePiezaTextField.setText(""); // Limpiar el campo de texto después de la eliminación
    });
    JPanel panelBotonEliminar = new JPanel();

    

    panelBotonEliminar.add(eliminarPiezaButton);

    panel.add(panelBotonEliminar, BorderLayout.SOUTH); // Agregar el botón en la parte inferior

    return panel;
    }


// Consultar Historial de la Pieza 

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



















    // requerimiento agregado
    private JPanel crearPanelCalendarioVentas() {
        JPanel panel = new JPanel(new GridLayout(0, 7, 2, 2));

    // Obtener el registro de ventas (reemplázalo con tu propio HashMap)
    HashMap<LocalDate, Integer> ventas = Cajero.getVentas();

    // Obtener la fecha actual
    LocalDate fechaActual = LocalDate.now();

    // Obtener el primer día del año actual
    LocalDate primerDiaAnio = LocalDate.of(fechaActual.getYear(), 1, 1);

    // Obtener el último día del año actual
    LocalDate ultimoDiaAnio = LocalDate.of(fechaActual.getYear(), 12, 31);

    // Calcular el número de días del año actual
    int diasAnio = ultimoDiaAnio.getDayOfYear();

    // Crear la matriz de etiquetas para representar el calendario de ventas
    JLabel[][] matrizCalendario = new JLabel[6][7];

    // Inicializar la matriz con etiquetas vacías
    for (int fila = 0; fila < 6; fila++) {
        for (int columna = 0; columna < 7; columna++) {
            matrizCalendario[fila][columna] = new JLabel("", SwingConstants.CENTER);
            panel.add(matrizCalendario[fila][columna]);
        }
    }

    // Llenar la matriz con las ventas realizadas en cada día del año
    int dia = 1;
for (LocalDate fecha = primerDiaAnio; fecha.isBefore(ultimoDiaAnio.plusDays(1)); fecha = fecha.plusDays(1)) {
    Integer ventaDia = ventas.getOrDefault(fecha, 0);
    int fila = (dia - 1) / 7;
    int columna = (dia - 1) % 7;
    if (fila < 6 && columna < 7) {
        matrizCalendario[fila][columna].setText(String.valueOf(ventaDia));
    }
    dia++;
}

    return panel;
    }
    

    public static void main(String[] args) {
        MenuAdmin admin = new MenuAdmin();
        admin.setVisible(true);
    }}