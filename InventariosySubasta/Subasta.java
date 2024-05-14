package InventariosySubasta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Subasta {

    private HashMap<String,Pieza> listadoSubasta;

    private static HashMap<String,Integer> Ofertas= new HashMap<String,Integer>();

    private Pieza pieza;

    private boolean Iniciar;


    public Subasta(){
        listadoSubasta= Inventario.getlistadoSubasta();
    }



    


public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

public Pieza getPieza(){
    return pieza;
}




    // Iniciar la subasta 
    public HashMap<Pieza,Integer> iniciarSubasta(){

    Calendar calendario = Calendar.getInstance();
    int dia = calendario.get(Calendar.DAY_OF_MONTH);

    // implementar si la subasta se puede empezar
    Pieza pieza= null;
    Integer precio= null;
    HashMap<Pieza,Integer>retorno=new HashMap<>();
    if (dia%2==0){
        this.setIniciar(true);
        Set<String> key = listadoSubasta.keySet();
        //convertir el set en lista 
        List<String> keylist= new ArrayList<>(key);
        

        String nombre = keylist.get(0);

        pieza = listadoSubasta.get(nombre);
        setPieza(pieza);
        precio= pieza.getPrecio();
        retorno.put(pieza, precio);
    }


    return retorno;

    }






    public static HashMap<String, Integer> getOfertas() {
        return Ofertas;
    }



    public boolean GetIniciar() {
        return Iniciar;
    }



    public void setIniciar(boolean iniciar) {
        Iniciar = iniciar;
    }

    public static void Registro(String cliente, Integer precio){
        Ofertas.put(cliente, precio);
    }


    

}



