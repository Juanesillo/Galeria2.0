package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Clientes.Cliente;
import Galeria.Galeria;
import LoginRegistro.userregister;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame {
    public Registro() {
        super("Registro de Usuario");

        // Establecer el tamaño de la ventana
        this.setSize(600, 600);

        // Terminar el programa cuando la GUI se cierre
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Ejecutar la GUI en la mitad de la pantalla
        this.setLocationRelativeTo(null);

        // Llamar al método para inicializar y agregar componentes
        iniciar();
    }

    public static Galeria galeria = new Galeria();

    private void iniciar() {
        // Agregar el título en la parte superior
        JPanel titulo = new JPanel();
        JLabel ltitulo = new JLabel("Bienvenido a Pinacoteca", JLabel.CENTER);
        ltitulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.add(ltitulo);
        Registro.this.add(titulo, BorderLayout.NORTH);

        // Agregar el pie en la parte inferior
        JPanel pie = new JPanel(new GridLayout(1, 2, 30, 5));
        pie.setBorder(new EmptyBorder(0, 30, 0, 30));
        JLabel Copyright = new JLabel("Registro USER ");
        Copyright.setFont(new Font("Arial", Font.BOLD, 15));
        pie.add(Copyright);
        Registro.this.add(pie, BorderLayout.SOUTH);

        // Agregar un panel en el centro con GridBagLayout
        JPanel logframe = new JPanel(new GridBagLayout());
        GridBagConstraints rules = new GridBagConstraints();
        logframe.setBorder(new EmptyBorder(5, 10, 5, 10));

        // Fuente más grande para los textos
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font textFieldFont = new Font("Arial", Font.PLAIN, 16);

        // Etiqueta y campo de texto para el usuario
        JLabel tituloUser = new JLabel("User:");
        tituloUser.setFont(labelFont);
        rules.gridx = 0;
        rules.gridy = 0;
        rules.gridwidth = 1;
        rules.anchor = GridBagConstraints.WEST;
        logframe.add(tituloUser, rules);

        JTextField user = new JTextField(10);
        user.setFont(textFieldFont);
        rules.gridx = 1;
        rules.gridy = 0;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.HORIZONTAL;
        logframe.add(user, rules);

        // Etiqueta y campo de texto para la contraseña
        JLabel tituloPass = new JLabel("Password:");
        tituloPass.setFont(labelFont);
        rules.gridx = 0;
        rules.gridy = 1;
        rules.gridwidth = 1;
        rules.fill = GridBagConstraints.NONE;
        logframe.add(tituloPass, rules);

        JTextField password = new JPasswordField(10);
        password.setFont(textFieldFont);
        rules.gridx = 1;
        rules.gridy = 1;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.HORIZONTAL;
        logframe.add(password, rules);

        // Etiqueta y campo de texto para el contacto
        JLabel tituloContacto = new JLabel("Contacto:");
        tituloContacto.setFont(labelFont);
        rules.gridx = 0;
        rules.gridy = 2;
        rules.gridwidth = 1;
        rules.fill = GridBagConstraints.NONE;
        logframe.add(tituloContacto, rules);

        JTextField contacto = new JTextField(10);
        contacto.setFont(textFieldFont);
        rules.gridx = 1;
        rules.gridy = 2;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.HORIZONTAL;
        logframe.add(contacto, rules);

        // Etiqueta y campo de texto para la cantidad de dinero
        JLabel tituloDinero = new JLabel("Cantidad Dinero:");
        tituloDinero.setFont(labelFont);
        rules.gridx = 0;
        rules.gridy = 3;
        rules.gridwidth = 1;
        rules.fill = GridBagConstraints.NONE;
        logframe.add(tituloDinero, rules);

        JTextField dinero = new JTextField(10);
        dinero.setFont(textFieldFont);
        rules.gridx = 1;
        rules.gridy = 3;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.HORIZONTAL;
        logframe.add(dinero, rules);

        // Botón de registro
        JButton registro = new JButton("REGISTRO");
        registro.setFont(new Font("Arial", Font.BOLD, 16));
        rules.gridx = 1;
        rules.gridy = 4;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.NONE;
        rules.anchor = GridBagConstraints.CENTER;

        registro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               String usuario = user.getText();
               Object contrasenia= password.getText();
               String contact= contacto.getText();
               double money= Double.parseDouble(dinero.getText());
               Cliente cliente= new Cliente(usuario, false, contact, contrasenia, money);
               Galeria.agregarCliente(cliente);
              userregister.RegistrarUsuario(usuario, contrasenia);

                //volver al panel de LOGIN
                Registro.this.dispose();
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
                JOptionPane.showMessageDialog(inicio, "Registro del cliente exitoso");
            }
            
        });

        logframe.add(registro, rules);

        // Botón de regresar
        JButton regresar = new JButton("REGRESAR");
        regresar.setFont(new Font("Arial", Font.BOLD, 16));
        rules.gridx = 1;
        rules.gridy = 6;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.NONE;
        rules.anchor = GridBagConstraints.CENTER;
       

        // Acción para el botón de regresar
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Registro.this.dispose();
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
            }
        });
        Registro.this.add(regresar, BorderLayout.SOUTH);
        Registro.this.add(logframe, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }
}
