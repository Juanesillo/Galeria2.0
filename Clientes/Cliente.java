package Clientes;

import java.util.HashMap;

import InventariosySubasta.Pieza;
import LoginRegistro.*;

public class Cliente extends Login {


    private HashMap<String,Pieza> Compras= new HashMap<String,Pieza>();
    private HashMap<String,Pieza> HistorialPieza= new HashMap<String,Pieza>();

    private String Contacto;
    private boolean Validacion;
    private double Dinero;


    public Cliente(String Contacto, boolean Validacion,String user, Object password, double Dinero){
        super(user, password);
        this.Contacto=Contacto;
        this.Validacion=Validacion;
        this.Dinero=Dinero;
    }





// Setters

    public void setValidacion(boolean validacion) {
    Validacion = validacion;
    }





    public void setDinero(double dinero) {
    Dinero = dinero;
    }


    public double getDinero(){
        return Dinero;
    }

    


    public String getContacto(){
        return Contacto;
    }


    public boolean getValidacion(){
        return Validacion;
    }
    public void CrearSolicitud(String titulo, String fecha, String lugarCreacion, 
    Integer precio, boolean disponible, String estadoInventario, String autor){

        //crear pieza 
        //

        Pieza pieza= new Pieza(titulo, fecha, lugarCreacion, precio, disponible, estadoInventario, autor);

        HistorialPieza.put(titulo,pieza);
    }

    public void AgregarCompra(String nombre, Pieza pieza){
        Compras.put(nombre, pieza);
    }
    public void AgregarHistorial(String nombre, Pieza pieza){
        HistorialPieza.put(nombre, pieza);
    }

    public  HashMap<String,Pieza> getHistorial(){
        return HistorialPieza;
    }


	public HashMap<String, Pieza> getCompras() {
		return Compras;
	} 


    

}
