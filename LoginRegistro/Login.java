package LoginRegistro;
import java.util.HashMap;

import Galeria.Galeria;

public class Login {

    private String user;
    private Object password;
    private static HashMap<String,Object>ListadoUsuario=new HashMap<String,Object>();
    

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
    public static void setListadoUsuario(HashMap<String, Object> listadoUsuario) {
        ListadoUsuario = listadoUsuario;
    }

    public static void RegistrarUsuario(String nombre, Object passoword){
        ListadoUsuario.put(nombre, passoword);
    }

    public static void RegistrarTrabajador(String nombre, Object passoword){
        Galeria.RegistrarTrabajador(nombre, passoword);
    }

    public static HashMap<String,Object> getlistadoUser(){

        return ListadoUsuario;
    }


}
