package InventariosySubasta;
import java.util.*;
public class Inventario {



    // listado de inventario 
    private static HashMap<String,Pieza> ListadoInventario= new HashMap<String, Pieza>();

    private static HashMap<String,Pieza> exhibidas= new HashMap<String, Pieza>();

    private static HashMap<String,Pieza> ListadoSubasta = new HashMap<String, Pieza>();

    private static HashMap<String,ArrayList<Pieza>> Artistas= new HashMap<String, ArrayList<Pieza>>();

    //historial piezas exhibidas

    

    // Historial Pieza

    //artista

    //historial de comprador 



    // constructor

    public Inventario(){}


    //getter de estructuras de datos
    
    public static HashMap<String,Pieza> getListadoInventario(){
        return ListadoInventario;
    }
    public HashMap<String,Pieza> exhibidas(){
        return exhibidas;
    }
    public static HashMap<String,Pieza> getlistadoSubasta(){
        return ListadoSubasta;
    }





    public static void AgregarDatos(Pieza pieza) throws Exception {
        try{
            ListadoInventario.put(pieza.getTitulo(),pieza);
            //agregar al mapa de historial artista 

            if (pieza.getEstado().equals("exhibida")){exhibidas.put(pieza.getTitulo(),pieza);}// registrar en mapa de Exhibidas
            if (pieza.getDisponible()){ListadoSubasta.put(pieza.getTitulo(),pieza);} // registrar en mapa de subasta
            


        }catch(Exception e){
            throw new Exception("Se presentaron problemas en la pieza");
        
        }
        
    }


    public static void eliminarPieza(String nombre){

        ListadoInventario.remove(nombre);
        exhibidas.remove(nombre);
        ListadoSubasta.remove(nombre);
    }


    public static void AgregarHistorialArtista(String nombre){
        ArrayList<Pieza> piezas= new ArrayList<Pieza>();
        for(Pieza pieza: ListadoInventario.values()){
            if (pieza.getAutor().equals(nombre)){
                piezas.add(pieza);
            }
        }

        Artistas.put(nombre, piezas);



    }


    public static HashMap<String,ArrayList<Pieza>> getHistorialArtistas(){
        return Artistas;
    }
    
    public static ArrayList<Pieza> getArtista(String nombre){
        return getHistorialArtistas().get(nombre);
    }

   

    


}
