package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Galeria.Galeria;
import Trabajadores.Cajero;
import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;
import InventariosySubasta.Subasta;
import java.awt.*;
import java.util.*;
import java.util.Map.Entry;
public class menuCajero extends JFrame {
    private JPanel panelDerecho;
    public menuCajero() {
        super("Cajero Galería");

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
        JButton registrarPagoBtn = new JButton("Registrar Pago");
        JButton cobrarSubastaBtn = new JButton("Cobrar Subasta");
        JButton consultarHistorialPiezaBtn = new JButton("Consultar Historial Pieza");
        JButton consultarHistorialArtistaBtn = new JButton("Consultar Historial Artista");
        JButton salirBtn = new JButton("Salir");

        // Agregar los botones al panel izquierdo
        panelIzquierdo.add(registrarPagoBtn);
        panelIzquierdo.add(cobrarSubastaBtn);
        panelIzquierdo.add(consultarHistorialPiezaBtn);
        panelIzquierdo.add(consultarHistorialArtistaBtn);
        panelIzquierdo.add(salirBtn);

        // Crear el panel derecho donde se mostrarán los distintos paneles
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new CardLayout());

        // Agregar paneles a la derecha
        panelDerecho.add(new JPanel(), "Vacio");
        panelDerecho.add(crearPanelRegistrarPago(), "RegistrarPago");
        panelDerecho.add(crearPanelCobrarSubasta(), "CobrarSubasta");
        panelDerecho.add(crearPanelConsultarHistorialPieza(), "ConsultarHistorialPieza");
        panelDerecho.add(crearPanelConsultarHistorialArtista(), "ConsultarHistorialArtista");

        // Añadir ActionListeners a los botones
        registrarPagoBtn.addActionListener(e -> mostrarPanel("RegistrarPago"));
        cobrarSubastaBtn.addActionListener(e -> mostrarPanel("CobrarSubasta"));
        consultarHistorialPiezaBtn.addActionListener(e -> mostrarPanel("ConsultarHistorialPieza"));
        consultarHistorialArtistaBtn.addActionListener(e -> mostrarPanel("ConsultarHistorialArtista"));
        salirBtn.addActionListener(e -> {
            menuCajero.this.dispose();
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

    private JPanel crearPanelRegistrarPago() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
    
        // Panel para ingresar el nombre de la pieza y el precio
        JTextField nombrePiezaTextField = new JTextField(20);
        JTextField precioTextField = new JTextField(20);
        JPanel panelNombreYPrecio = new JPanel(new GridLayout(2, 2, 5, 5));
        panelNombreYPrecio.add(new JLabel("Nombre de la pieza: "));
        panelNombreYPrecio.add(nombrePiezaTextField);
        panelNombreYPrecio.add(new JLabel("Precio: "));
        panelNombreYPrecio.add(precioTextField);
    
        // Panel para seleccionar el método de pago
        String[] metodosPago = {"Tarjeta Normal", "Efectivo", "Tarjeta de Crédito"};
        JComboBox<String> metodoPagoComboBox = new JComboBox<>(metodosPago);
        JPanel panelMetodoPago = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelMetodoPago.add(new JLabel("Método de Pago: "));
        panelMetodoPago.add(metodoPagoComboBox);
    
        // Paneles para campos adicionales según el método de pago
        JPanel panelCamposAdicionales = new JPanel(new CardLayout());
        JPanel panelTarjetaNormal = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTarjetaNormal.add(new JLabel("Número de Tarjeta: "));
        JTextField numeroTarjetaNormalTextField = new JTextField(20);
        panelTarjetaNormal.add(numeroTarjetaNormalTextField);
    
        JPanel panelEfectivo = new JPanel(); // No se requieren campos adicionales para efectivo
    
        JPanel panelTarjetaCredito = new JPanel(new GridLayout(3, 2, 5, 5));
        panelTarjetaCredito.add(new JLabel("Número de Tarjeta: "));
        JTextField numeroTarjetaCreditoTextField = new JTextField(20);
        panelTarjetaCredito.add(numeroTarjetaCreditoTextField);
        panelTarjetaCredito.add(new JLabel("Fecha de Expiración: "));
        JTextField fechaExpiracionTextField = new JTextField(10);
        panelTarjetaCredito.add(fechaExpiracionTextField);
        panelTarjetaCredito.add(new JLabel("CVV: "));
        JTextField cvvTextField = new JTextField(5);
        panelTarjetaCredito.add(cvvTextField);
    
        panelCamposAdicionales.add(panelTarjetaNormal, "Tarjeta Normal");
        panelCamposAdicionales.add(panelEfectivo, "Efectivo");
        panelCamposAdicionales.add(panelTarjetaCredito, "Tarjeta de Crédito");
    
        // Cambiar paneles adicionales según el método de pago seleccionado
        metodoPagoComboBox.addActionListener(e -> {
            CardLayout cl = (CardLayout) (panelCamposAdicionales.getLayout());
            cl.show(panelCamposAdicionales, (String) metodoPagoComboBox.getSelectedItem());
        });
    
        // Panel para el botón de registro de pago
        JButton registrarPagoButton = new JButton("Registrar Pago");
        JPanel panelBoton = new JPanel();
        panelBoton.add(registrarPagoButton);
    
        // Acción al presionar el botón de registro de pago
        registrarPagoButton.addActionListener(e -> {
            String nombrePieza = nombrePiezaTextField.getText();
            Integer precio = Integer.parseInt(precioTextField.getText());
            String metodoPago = (String) metodoPagoComboBox.getSelectedItem();
    
            if (Galeria.listadoInventario().containsKey(nombrePieza)) {
                if (metodoPago.equals("Tarjeta Normal")) {
                    String numeroTarjeta = numeroTarjetaNormalTextField.getText();
                    // Implementar la lógica de pago con tarjeta normal
                    System.out.println("Pago registrado para la pieza: " + nombrePieza + ", Precio: " + precio + ", Método de Pago: Tarjeta Normal, Número de Tarjeta: " + numeroTarjeta);
                } else if (metodoPago.equals("Efectivo")) {
                    // Implementar la lógica de pago en efectivo
                    System.out.println("Pago registrado para la pieza: " + nombrePieza + ", Precio: " + precio + ", Método de Pago: Efectivo");
                } else if (metodoPago.equals("Tarjeta de Crédito")) {
                    String numeroTarjeta = numeroTarjetaCreditoTextField.getText();
                    String fechaExpiracion = fechaExpiracionTextField.getText();
                    String cvv = cvvTextField.getText();
                    // Implementar la lógica de pago con tarjeta de crédito
                    System.out.println("Pago registrado para la pieza: " + nombrePieza + ", Precio: " + precio + ", Método de Pago: Tarjeta de Crédito, Número de Tarjeta: " + numeroTarjeta + ", Fecha de Expiración: " + fechaExpiracion + ", CVV: " + cvv);
                }
                Cajero.RegistrarCompra(nombrePieza, precio);
                JOptionPane.showMessageDialog(menuCajero.this, "Pago registrado para la pieza: " + nombrePieza + ", Precio: " + precio);
            } else {
                JOptionPane.showMessageDialog(menuCajero.this, "No se encontró la pieza");
                System.err.println(Galeria.listadoInventario());
            }
    
            // Limpiar los campos de texto después del registro
            nombrePiezaTextField.setText("");
            precioTextField.setText("");
            numeroTarjetaNormalTextField.setText("");
            numeroTarjetaCreditoTextField.setText("");
            fechaExpiracionTextField.setText("");
            cvvTextField.setText("");
        });
    
        // Panel para organizar los componentes
        JPanel panelRegistroPago = new JPanel();
        panelRegistroPago.setLayout(new BorderLayout());
        panelRegistroPago.add(panelNombreYPrecio, BorderLayout.NORTH);
        panelRegistroPago.add(panelMetodoPago, BorderLayout.CENTER);
        panelRegistroPago.add(panelCamposAdicionales, BorderLayout.SOUTH);
        panelRegistroPago.add(panelBoton, BorderLayout.PAGE_END);
    
        panel.add(panelRegistroPago, BorderLayout.CENTER);
    
        return panel;
    }

    private JPanel crearPanelCobrarSubasta() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
    
        // Botón para cobrar subasta
        JButton cobrarSubastaButton = new JButton("Cobrar Subasta");
        panel.add(cobrarSubastaButton);
    
        // Acción al presionar el botón de cobrar subasta
        cobrarSubastaButton.addActionListener(e -> {
           ArrayList<Subasta> subastas =  Galeria.getSubastas();
                for(int i=0; i< Galeria.getSubastas().size();i++){  
                    subastas.get(i);
                    for( Entry<String, Integer> entry:  Subasta.getOfertas().entrySet()){

                        String nombre= entry.getKey(); // nombre del cliente
                        Integer value = entry.getValue();
                        Cajero.RegistrarCompra(nombre, value);
                    }}
            JOptionPane.showMessageDialog(menuCajero.this, "Subastas cobradas exitosamente.");
        });
    
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
        menuCajero cajero = new menuCajero();
        cajero.setVisible(true);
    }
}
