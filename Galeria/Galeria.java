package Galeria;
import java.util.ArrayList;
import java.util.HashMap;

import Clientes.Cliente;
import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;


public class Galeria {

    // lista clientes
    // HistorialPieza
    private static HashMap<String,Object>ListadoTrabajadores=new HashMap<String,Object>();
    private static ArrayList<Cliente>ListaClientes = new ArrayList<Cliente>();
  

    public Galeria(){
        
    }

    // impemeentar setters
    public void setInventario(Inventario inventario) {
    }    // Por consola se crearián piezas



    public static ArrayList<Cliente> getlistaClientes(){
        return ListaClientes;
    }

    public HashMap<String,ArrayList<Pieza>> consultarArtista(){

        return Inventario.getHistorialArtista();
    }

    public static  HashMap<String,Object> getTrabajadores(){
        return ListadoTrabajadores;
    }

    public static void RegistrarTrabajador(String user, Object password){
        ListadoTrabajadores.put(user, password);
    }

    public static void setListadoTrabajadores(HashMap<String, Object> listadoTrabajadores) {
        ListadoTrabajadores = listadoTrabajadores;
    }

    public static void agregarCliente(Cliente cliente){
        ListaClientes.add(cliente);
    }
  







}
