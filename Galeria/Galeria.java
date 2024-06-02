package Galeria;
import java.util.ArrayList;
import java.util.HashMap;
import InventariosySubasta.Subasta;
import LoginRegistro.userregister;
import Clientes.Cliente;
import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;


public class Galeria {

    // lista clientes
    // HistorialPieza
    private static ArrayList<Cliente>ListaClientes = new ArrayList<Cliente>();
    private static HashMap<String,Pieza>SolicitudPieza= new HashMap<String,Pieza>();
    private static ArrayList<String>SolicitudCompra= new ArrayList<String>();  
    private static ArrayList<Subasta>listaSubasta= new ArrayList<Subasta>();

    public Galeria(){
        
    }

    // impemeentar setters
    public void setInventario(Inventario inventario) {
    }    // Por consola se crearián piezas


    public static ArrayList<Cliente> getlistaClientes(){
        return ListaClientes;
    }

    public static void agregarCliente(Cliente cliente){
        ListaClientes.add(cliente);
    }


    public static void SolicitudPieza(String nombre, Pieza pieza){
        SolicitudPieza.put(nombre, pieza);
    }


    public static void comprar(String nombre){
        SolicitudCompra.add(nombre);
    }

    public static HashMap<String,Pieza> getsolicituPiez(){ 
    	return SolicitudPieza;}
    
    // Historial artista
	public static HashMap<String, ArrayList<Pieza>> historialArtistas() {
		
		return Inventario.getHistorialArtistas();
	}

	public static ArrayList<Pieza> historialArtista(String nombre){
        return Inventario.getArtista(nombre);
    }
	
	//Historial Pieza
	
	public static HashMap<String, ArrayList<Object>> historialPiezas() {
		
		return Pieza.getHistorialPiezas();
	}

	public static ArrayList<Object> historialPieza(String nombre){
        return Pieza.getHistorialPieza(nombre);
    }
	
	
	// Trabajadores
	public static void crearListadoTrabajadores(HashMap<String, Object> listadoTrabajadores) {
		userregister.setListadoTrabajadores(listadoTrabajadores);
	}
	public static HashMap<String, Object> listadoTrabajadores() {
		return userregister.getListadoTrabajadores();
	}
	
	//Inventario
	public static HashMap<String, Pieza> listadoInventario() {
		
		return Inventario.getListadoInventario();}
	

    // subastas existentes 
    public static void AgregarSubasta(Subasta subasta){

        listaSubasta.add(subasta);
    }

    public static ArrayList<Subasta> getSubastas(){

        return listaSubasta;
    }
  






	

}
