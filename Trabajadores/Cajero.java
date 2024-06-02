package Trabajadores;

import java.time.LocalDate;
import java.util.HashMap;

import Clientes.Cliente;
import InventariosySubasta.Pieza;
import LoginRegistro.userregister;

public class Cajero extends userregister {
    

    private static HashMap<String, Integer>registroCompras = new HashMap<String, Integer>();
    private static HashMap<LocalDate, Integer> ventas= new HashMap<LocalDate,Integer>();


    public Cajero(String user, Object password){
        super(user, password);
    }


    public static HashMap<String, Integer> getRegistroCompras(){
        return registroCompras;
    }

    public static void RegistrarCompra(String nombrePieza, Integer Costo){
        registroCompras.put(nombrePieza, Costo);
        ventas.put(LocalDate.now(),Costo);
    }

    // validar que se puede realizar la compra
    public boolean validarCompra(Pieza pieza, Cliente cliente){
        boolean retorno= false;
        double dinero= cliente.getDinero();
    
       if (dinero >= pieza.getPrecio()){
        cliente.setDinero(dinero-pieza.getPrecio());
        retorno= true;
       }

       return retorno;

    }


    public static HashMap<LocalDate, Integer> getVentas() {
        return ventas;
    }









}
