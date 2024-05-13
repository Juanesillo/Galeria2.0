package Trabajadores;

import java.util.HashMap;

import Clientes.Cliente;
import InventariosySubasta.Pieza;
import LoginRegistro.Login;

public class Cajero extends Login {
    

    private static HashMap<String, Integer>registroCompras = new HashMap<String, Integer>();

    public Cajero(String user, Object password){
        super(user, password);
    }


    public static HashMap<String, Integer> getRegistroCompras(){
        return registroCompras;
    }

    public void RegistrarCompra(String cliente, Integer Costo){
        registroCompras.put(cliente, Costo);
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









}
