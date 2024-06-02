package Trabajadores;
import java.util.HashMap;

import Clientes.Cliente;
import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;
import LoginRegistro.*;



public class Administrador extends userregister {

    //lista solicitudes Cliente

    public Administrador(String user, Object password) {
        super(user, password);
        
        
    }


    public static void RegistrarPieza(Cliente cliente) throws Exception{
        HashMap<String,Pieza> listadoPiezas= cliente.getHistorial();
        try{
            for (Pieza pieza: listadoPiezas.values() ){
            Inventario.AgregarDatos(pieza);
        }
    }catch(Exception e){
        System.out.println("error agregando Pieza");
    }
        
      
    }

}
