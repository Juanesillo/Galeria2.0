package GUI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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

    private void iniciar() {
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
        logframe.add(login, rules);

        // Agregar el panel al centro del JFrame
       

        //considerando el boton de registro 
        
        JButton registro = new JButton("REGISTRO");
        rules.gridx = 1;
        rules.gridy = 2;
        rules.gridwidth = 1;
        rules.fill = GridBagConstraints.HORIZONTAL;
        logframe.add(registro, rules);



        Inicio.this.add(logframe, BorderLayout.CENTER);




    }
}
