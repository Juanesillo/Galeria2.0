package GUI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import Galeria.Galeria;
import LoginRegistro.userregister;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Inicio extends JFrame {
    public Inicio() {
        super("Inicio Galeria");

        // Establecer el tamaño de la ventana
        this.setSize(600, 600);

        // Terminar el programa cuando la GUI se cierre
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Ejecutar la GUI en la mitad de la pantalla
        this.setLocationRelativeTo(null);

        // Llamar al método para inicializar y agregar componentes
        iniciar();
    }


    public static Galeria galeria= new Galeria();
    







    private void iniciar() {


        // agregar credenciales de trabajadores
    HashMap<String,Object>listadoTrabajadores= new HashMap<String,Object>();
    listadoTrabajadores.put("admin", "admin");
    listadoTrabajadores.put("Cajero", "Cajero");
    listadoTrabajadores.put("Operador", "Operador");
    
    userregister.setListadoTrabajadores(listadoTrabajadores);

    // persistencia usuarios 
    //leer archivo de usuarios 

    try {
        HashMap<String, Object> users= leerTrabajadoresClientes();
        userregister.setListadoUsuario(users);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }




        // Agregar el título en la parte superior
        JPanel titulo = new JPanel();
        JLabel ltitulo = new JLabel("Bienvenido a Pinacoteca", JLabel.CENTER);
        ltitulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.add(ltitulo);
        Inicio.this.add(titulo, BorderLayout.NORTH);

        // Agregar el pie en la parte inferior
        JPanel pie = new JPanel(new GridLayout(1, 2, 30, 5));
        pie.setBorder(new EmptyBorder(0, 30, 0, 30));
        JLabel Copyright = new JLabel("DPOO2024");
        Copyright.setFont(new Font("Arial", Font.BOLD, 15));
        pie.add(Copyright);
        Inicio.this.add(pie, BorderLayout.SOUTH);

        // Agregar un panel en el centro con GridBagLayout
        JPanel logframe = new JPanel(new GridBagLayout());
        GridBagConstraints rules = new GridBagConstraints();
        logframe.setBorder(new EmptyBorder(5, 10, 5, 10));
        
        // agregar la imagen 

        ImageIcon imagen = new ImageIcon("GUI/data/logo.png");
        JLabel imagenLabel = new JLabel();
        imagenLabel.setSize(200,200);
        imagenLabel.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT)));
        rules.gridx = 0;
        rules.gridy = 0;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.HORIZONTAL;
        rules.weightx=0.0;
        rules.weighty=1.0;
        logframe.add(imagenLabel, rules);


        JButton login = new JButton("LOGIN");
        rules.gridx = 1;
        rules.gridy = 1;
        rules.gridwidth = 1;
        rules.weightx=0.0;
        rules.weighty=1.0;
        rules.fill = GridBagConstraints.HORIZONTAL;

        //funcionalidad de los botones

        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               Inicio.this.dispose();
               Login login = new Login();
               login.setVisible(true);
               JOptionPane.showMessageDialog(login, "Ingrese sus credenciales");
            }
            
        });

        logframe.add(login, rules);

        // Agregar el panel al centro del JFrame
       

        //considerando el boton de registro 
        
        JButton registro = new JButton("REGISTRO");
        rules.gridx = 1;
        rules.gridy = 2;
        rules.gridwidth = 1;
        rules.fill = GridBagConstraints.HORIZONTAL;
        logframe.add(registro, rules);
        // ajustes Boton de registro 
        

        registro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio.this.dispose();
                Registro registro= new Registro();
                registro.setVisible(true);
                JOptionPane.showMessageDialog(login, "Valide su información");

            }
            
        });


        Inicio.this.add(logframe, BorderLayout.CENTER);




    }


    // cargar datos de usuarios 


    public static HashMap<String, Object> leerTrabajadoresClientes() throws IOException {
    String nombreArchivo = "ArchivosPersistencia/Registros.txt";
    HashMap<String, Object> usuarios = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
        String line;
        // Saltar la primera línea del archivo (título)
        reader.readLine();
        
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(": ");
            if (parts.length == 2) {
                String user = parts[0];
                String password = parts[1];
                usuarios.put(user, password);
            }
        }
    }

    return usuarios;
}


}
