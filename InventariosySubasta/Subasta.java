package InventariosySubasta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class Subasta {

    private static HashMap<String,Pieza> listadoSubasta;

    private static HashMap<String,Integer> Ofertas= new HashMap<String,Integer>();
    private static HashMap<Pieza,Integer> subasta= new HashMap<Pieza,Integer>();


    private static Pieza pieza;


    public Subasta(){
        listadoSubasta= Inventario.getlistadoSubasta();
    }



    







    // Iniciar la subasta 
    public static void  iniciarSubasta(){

    Calendar calendario = Calendar.getInstance();
    int dia = calendario.get(Calendar.DAY_OF_MONTH);

    // implementar si la subasta se puede empezar
    Pieza pieza= null;
    Integer precio= null;
 
    if (dia%2==0){
        Set<String> key = listadoSubasta.keySet();
        //convertir el set en lista 
        List<String> keylist= new ArrayList<>(key);
        String nombre = keylist.get(0);
        pieza = listadoSubasta.get(nombre);
        setPieza(pieza);
        precio= pieza.getPrecio();
    }

    subasta.put(pieza, precio);

    }






    public static void setPieza(Pieza pieza) {
        Subasta.pieza = pieza;
    }











    public static HashMap<String, Integer> getOfertas() {
        return Ofertas;
    }



    public static void Registro(String cliente, Integer precio){
        Ofertas.put(cliente, precio);
    }











    public static Pieza getPieza() {
        return pieza;
    }











    public static HashMap<Pieza, Integer> getSubasta() {
        return subasta;
    }





















   


    

}



