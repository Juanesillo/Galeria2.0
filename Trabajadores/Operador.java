package Trabajadores;

import java.util.HashMap;

import java.util.Map.Entry;


import InventariosySubasta.Pieza;
import InventariosySubasta.Subasta;
import LoginRegistro.userregister;

public class Operador extends userregister{


    private static  HashMap<String,Pieza> Ganadores= new HashMap<String,Pieza>();

    public Operador(String user, Object password){
        super(user, password);
    }
    
    public static void iniciarLaSubasta() {
    	Subasta.iniciarSubasta();
    }

    public  static HashMap<String,Pieza> ObtenerGanador(){
        return Ganadores;
    }

    public static void registrarSubasta(String nombre, Integer precio){
        Subasta.Registro(nombre, precio);
    }
    public static void registroGanador(){

        Integer maxValor=0;
        String claveMaxValor = null;
        for (Entry<String, Integer> entry : Subasta.getOfertas().entrySet() ) {

                    String clave = entry.getKey();
               
                    Integer valor= entry.getValue();

                    if(valor>maxValor){
                    maxValor=valor;
                    claveMaxValor=clave;}  

                    }
        Cajero.RegistrarCompra(claveMaxValor, maxValor);
        Ganadores.put(claveMaxValor, Subasta.getPieza());




    }


}
