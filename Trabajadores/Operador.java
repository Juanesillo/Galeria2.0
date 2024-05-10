package Trabajadores;

import java.util.HashMap;

import InventariosySubasta.Pieza;
import InventariosySubasta.Subasta;
import LoginRegistro.Login;

public class Operador extends Login{


    private HashMap<String,Pieza> Ganadores= new HashMap<String,Pieza>();

    public Operador(String user, Object password){
        super(user, password);
    }

    public  HashMap<String,Pieza> ObtenerGanador(){
        return Ganadores;
    }

    public void registrarSubasta(String nombre, Integer precio){
        Subasta.Registro(nombre, precio);
    }
}
