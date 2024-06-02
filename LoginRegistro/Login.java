package LoginRegistro;
import java.util.HashMap;



public class Login {

    private String user;
    private Object password;
    private static HashMap<String,Object>ListadoUsuario=new HashMap<String,Object>();
    private static HashMap<String,Object>ListadoTrabajadores=new HashMap<String,Object>();

    public Login(String user, Object password){

        this.user=user;
        this.password=password;
    }

    public String getuser(){
        return user;
    }

    public Object getPassword(){
        return password;
    }

    public static boolean ValidarUser(String nombre, Object password){
        boolean validacion = false;
        if(ListadoUsuario.containsKey(nombre)){
            if(ListadoUsuario.get(nombre).equals(password)){
                validacion= true;
            }


        }

        return validacion; 

    }
    

    public static void RegistrarUsuario(String nombre, Object passoword){
        ListadoUsuario.put(nombre, passoword);
    }

    public static void RegistrarTrabajador(String nombre, Object passoword){
        ListadoTrabajadores.put(nombre, passoword);
    }

    public static HashMap<String,Object> getlistadoUser(){

        return ListadoUsuario;
    }

   

    // setters de los usuarios 

    public static void setListadoTrabajadores(HashMap<String, Object> listadoTrabajadores) {
        ListadoTrabajadores = listadoTrabajadores;
    }

    public static void setListadoUsuario(HashMap<String, Object> listadoUsuario) {
        ListadoUsuario = listadoUsuario;
    }


    

}
