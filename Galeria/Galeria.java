package Galeria;
import java.util.ArrayList;
import java.util.HashMap;
import InventariosySubasta.Subasta;
import LoginRegistro.Login;
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
    
	public static HashMap<String, ArrayList<Pieza>> historialArtistas() {
		
		return Inventario.getHistorialArtistas();
	}

	public static ArrayList<Pieza> historialArtista(String nombre){
        return Inventario.getArtista(nombre);
    }
	
	public static HashMap<String, Object> historialPiezas() {
		
		return Pieza.getHistorialPiezas();
	}

	public static Object historialPieza(String nombre){
        return Pieza.getHistorialPieza(nombre);
    }
	
	public static HashMap<String, Pieza> listadoInventario() {
		
		return Inventario.getListadoInventario();
	}
	
	public static void agregarPieza(Pieza pieza) throws Exception {
		Inventario.AgregarDatos(pieza);
	}
	
	public static void eliminarPieza(String nombre) {
		Inventario.eliminarPieza(nombre);
	}
	
	public static void crearListadoUsuarios(HashMap<String, Object> listadoUsuario) {
		Login.setListadoUsuario(listadoUsuario);
	}
	
	public static HashMap<String, Object> listadoUsuarios() {
		return Login.getlistadoUser();
	}
	
	public static void agregarNuevoUsuario(String usuario, Object contraseña) {
		Login.RegistrarUsuario(usuario, contraseña);
	}
	
	

    // subastas existentes 
    public static void AgregarSubasta(Subasta subasta){

        listaSubasta.add(subasta);
    }

    public static ArrayList<Subasta> getSubastas(){

        return listaSubasta;
    }
  






	

}
