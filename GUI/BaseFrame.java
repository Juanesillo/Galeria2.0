package GUI;

import javax.swing.*;


public abstract class BaseFrame extends JFrame{

    
    // crear clase galeria y crearla de cero aca 
    // Crear el constructor del BaseFrame que inicializa la gui 
    public BaseFrame(String titulo){
        initialize(titulo);
    }


    // inicio de los metodos empleados para la gui // inicializar la gui cerrarla y agregar componentes
    private void initialize(String titulo){
        
        // Cambiar el fondo de la GUI 

        
        
        
        
        
        // inicializa el JFrame Propiedades y agrega un titulo a la barra
        setTitle(titulo);

        // Set de Tamaño (en Pixeles)
        // Ejemplo ajstable width:420 y heigt:600
        setSize(420,500 );

        // terminar el programa cuando la GUI se cierre

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //ajustar en null para especificar de manera manual los componentes de la gui 
        setLayout(null);

        // en caso de prevenir el resize de la gui aplicar el comando 
        setResizable(false );


        // ejecutar la gui en la mitad de la pantalla 

        setLocationRelativeTo(null);

        // llamar la subclase addguicomponent

        addguicomponent();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
            
            }
        });

       
    }

    // addguicomponent es un metodo abstracto que puede ser modificado dependiendo del caso en la aplicacíón 

    protected abstract void addguicomponent();



    
}

