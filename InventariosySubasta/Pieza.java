package InventariosySubasta;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Pieza {


    // las piezas que van a estar dentro de la galeria 


    // una pieza puede tener diversas específicaciones 
    // atributos generales de una pieza 


    private String titulo; // Titulo de la pieza 
    private String fecha; // fecha de creación
    private String lugarCreacion;
    private Integer precio; // precio de la pieza
    private boolean disponible; // esta disponible la pieza
    private String estadoInventario;// exhibida o almacenada
    private String autor;

    private static HashMap<String,Object>Especificos= new HashMap<String,Object>();

    private static HashMap<String,Object>Historial= new HashMap<String,Object>();
    // Object es un Array
        // Pieza, dueño, por cuanto ha sido vendida y cuando

    // constructor de la pieza 

    public Pieza(String titulo, String fecha, String lugarCreacion, 
    Integer precio, boolean disponible, String estadoInventario, String autor){
        
        this.titulo=titulo;
        this.fecha=fecha;
        this.lugarCreacion=lugarCreacion;
        this.precio=precio;
        this.disponible=disponible;
        this.estadoInventario=estadoInventario;
        this.autor= autor;
    }

    // es importante que existan muchos atributos de piezas ???
    //implementar solo sin atributos generales por ahora 




    // getters y setters
    public void setEstadoInventario(String estadoInventario){

        this.estadoInventario=estadoInventario;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFehca() {
        return fecha;
    }

    public String getLugarCreacion() {
        return lugarCreacion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public String getEstado() {
        return estadoInventario;
    }

    public String getAutor() {
        return autor;
    }
    
    public static HashMap<String, Object> getHistorialPiezas(){
    	return Historial;}
    

    // metodos Pieza



    public static void AgregarEspecificos(String key, Object value){
    	Especificos.put(key, value);}
    
    public static void AgregarHistorial(String key, Object value){
    	Historial.put(key, value);}
    
  
    public static Object getHistorialPieza(String nombre){
        return getHistorialPiezas().get(nombre);
    }



    //metodos prueba

    public void getInfo(){
        String titulo= this.titulo;
        String autor= this.autor;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(fecha);
        Integer precio= this.precio;
        String lugarCreacion= this.lugarCreacion;
        String disponible= String.valueOf(this.disponible);
        String estadoInventario= this.estadoInventario;

        System.out.println(titulo+autor+ strDate+ precio+lugarCreacion+disponible+estadoInventario);

        

    }
    











}
