package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Galeria.Galeria;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Login extends JFrame {
    public Login() {
        super("Login Galeria");

        // Establecer el tamaño de la ventana
        this.setSize(600, 600);

        // Terminar el programa cuando la GUI se cierre
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Ejecutar la GUI en la mitad de la pantalla
        this.setLocationRelativeTo(null);

        // Llamar al método para inicializar y agregar componentes
        iniciar();
    }

    private void iniciar() {
        // Agregar el título en la parte superior
        JPanel titulo = new JPanel();
        JLabel ltitulo = new JLabel("Login Pinacoteca", JLabel.CENTER);
        ltitulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.add(ltitulo);
        Login.this.add(titulo, BorderLayout.NORTH);

        // Agregar el pie en la parte inferior
        JPanel pie = new JPanel(new GridLayout(1, 2, 30, 5));
        pie.setBorder(new EmptyBorder(0, 30, 0, 30));
        JLabel Copyright = new JLabel("DPOO2024");
        Copyright.setFont(new Font("Arial", Font.BOLD, 15));
        pie.add(Copyright);
        Login.this.add(pie, BorderLayout.SOUTH);

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

        JPasswordField password = new JPasswordField(10);
        password.setFont(textFieldFont);
        rules.gridx = 1;
        rules.gridy = 1;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.HORIZONTAL;
        logframe.add(password, rules);

        // Botón de login
        JButton loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        rules.gridx = 1;
        rules.gridy = 2;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.NONE;
        rules.anchor = GridBagConstraints.CENTER;
        logframe.add(loginButton, rules);

        // Botón de regresar
        JButton regresar = new JButton("REGRESAR");
        regresar.setFont(new Font("Arial", Font.BOLD, 16));
        rules.gridx = 1;
        rules.gridy = 3;
        rules.gridwidth = 2;
        rules.fill = GridBagConstraints.NONE;
        rules.anchor = GridBagConstraints.CENTER;
        Login.this.add(regresar, BorderLayout.SOUTH);

        // Acción para el botón de regresar
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.this.dispose();
                Inicio inicio = new Inicio();
                inicio.setVisible(true);
            }
        });

        // Acción para el botón de login (puedes personalizar esto según tus necesidades)
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HashMap<String,Object>User = Galeria.listadoUsuarios();
                HashMap<String,Object> trabajadores=LoginRegistro.Login.getlistadoUser();


                System.out.println(User);
                System.out.println(trabajadores);

                // Aquí puedes agregar la lógica para el login
                String username = user.getText();
                String passwordText = String.valueOf(password.getPassword());

                // Simulación de autenticación (puedes reemplazar esto con tu lógica)
                if (trabajadores.containsKey(username) && trabajadores.get(username).equals(passwordText)) {
                    JOptionPane.showMessageDialog(Login.this, "Bienvenido Señor administrador");
                    // validaciones para los trabajadores 
                    //interfaz administrador
                    if (user.equals("Admin")){
                        Login.this.dispose();
                       MenuAdmin menuAdmin= new MenuAdmin();
                        menuAdmin.setVisible(true);
                        JOptionPane.showMessageDialog(menuAdmin, "Bienvenido Administrador");

                    

                    }
                    //interfaz Cajero
                    else if (user.equals("Cajero")){
                        Login.this.dispose();
                        menuCajero MenuCajero= new menuCajero();
                        MenuCajero.setVisible(true);
                        JOptionPane.showMessageDialog(MenuCajero, "Bienvenido Cajero");

                    }
                    //interfaz Operador
                    else if (user.equals("Operador")){
                        Login.this.dispose();
                        MenuOperador menuOperador= new MenuOperador();
                        menuOperador.setVisible(true);
                        JOptionPane.showMessageDialog(menuOperador, "Bienvenido Operador");

                    }

                } 


                else if (User.containsKey(username) && User.get(username).equals(passwordText)){
                    Login.this.dispose();
                    MenuUser menuUser= new MenuUser();
                    menuUser.setVisible(true);
                    JOptionPane.showMessageDialog(menuUser, "Bienvenido "+ username);



                }
                
                
                
                
                
                
                else {
                    JOptionPane.showMessageDialog(Login.this, "Usuario o contraseña incorrectos");
                }
            }
        });

        Login.this.add(logframe, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }


}
