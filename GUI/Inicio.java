package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class Inicio extends BaseFrame {
    public Inicio() {
        super("Inicio de sesion Galeria");
    }

    @Override
    protected void addguicomponent() {
        
            // agregar el titulo en la parte superiror 
            JPanel titulo= new JPanel();
            JLabel ltitulo= new JLabel("Bienvenido a Pinacoteca",JLabel.CENTER);
            ltitulo.setFont(new Font("Arial",Font.BOLD,22));
            titulo.add(ltitulo);
            Inicio.this.add(titulo,BorderLayout.NORTH);
        
            // agregar sur 
            JPanel pie= new JPanel(new GridLayout(1,2,30,5));
            pie.setBorder(new EmptyBorder(0,30,0,30));
            JLabel Copyright= new JLabel("DPOO204");
            Copyright.setFont(new Font("Arial",Font.BOLD,22));
            pie.add(Copyright);
            Inicio.this.add(pie,BorderLayout.SOUTH);
        
    
            // centro
            JPanel logPanel= new JPanel(new GridBagLayout());
            logPanel.setBorder(new EmptyBorder(5,10,5,10));
            GridBagConstraints rules = new GridBagConstraints();
            
    
    
           
    }


   
}