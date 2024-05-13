package Consola;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Clientes.Cliente;
import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;
import LoginRegistro.Login;
import Galeria.Galeria;
public class ConsolaLogin {
      public static void main(String[] args) throws Exception {
        CargarInformacionLogin();
        
        System.out.println("\u001B[36mBienvenido a la Galería\u001B[0m");
        Scanner scanner= new Scanner(System.in);
        boolean running= true;
        
        while (running) {
            System.out.println("\n¿Qué desea hacer?");
            System.out.println("1. Registrarse en la Galería");
            System.out.println("2. Iniciar sesión en la Galería");
            System.out.println("3. Salir");
            // opción Registrar Usuarios y Trabajadores
            Integer input= Integer.parseInt(scanner.nextLine());
            if(input==1){ System.out.println("\n\u001B[33mRegistro\u001B[0m");    
            RegistroGaleria(scanner); PersistenciaTrabajadoresClientes();guardarClientes();
            // almacenar usuarios y claves
            
        }
            // Opción Iniciar Sesion y ejecutar código si es User o trabajador
            else if(input==2){CargarInformacionLogin();
            
            // Iniciar Validacion por Usuario

            System.out.println("\n Por favor digite su Usuario");
            String user= scanner.nextLine();
            System.out.println("Por favor Digite su contraseña");
            String password = scanner.nextLine();
            HashMap<String,Object>User = Login.getlistadoUser();
            HashMap<String,Object> trabajadores=Galeria.getTrabajadores();

            if(User.containsKey(user) && User.get(user).equals(password)){
                System.out.println("Bienvenido Usuario" + user+"\n");
                // desplegar opciones del cliente
                consolarUser(scanner);
                

            }
            else if(trabajadores.containsKey(user) && trabajadores.get(user).equals(password)){
                System.out.println("Bienvenido"+user);
                if (user.equals("Admin")){
                    System.out.println("Consola Adminstrador");
                    consolaAdmin(scanner);


                }
                else if (user.equals("Cajero")){
                    System.out.println("Consola Cajero");
                    consolaCajero(scanner);
                }
                else if (user.equals("Operador")){
                    System.out.println("Consola Operador");
                    consolaOperador(scanner);
                }




                // dividir en cosola Admin
                // Consola Operador 
                //Consola Cajero
            }
            else{
                System.out.println("Usuario no registrado");
            }
            }
            else{System.out.println("Esperamos que vuelva pronto"); running=false;}
            PersistenciaTrabajadoresClientes();


        }
        scanner.close();


    }

   // Registrar una Pieza



    public static void consolaAdmin(Scanner scanner){}
    public static void consolaCajero(Scanner scanner){}
    public static void consolaOperador(Scanner scanner){}




    //consola User

    public static void consolarUser(Scanner scanner){
        boolean consolacliente=true;
        while (consolacliente) {
            
        System.out.println("1.Comprar una pieza");
        System.out.println("2. Registrar una pieza");
        System.out.println("3.Consultar Historial pieza");
        System.out.println("4.Consultar Historial Artista");
        System.out.println("5.Salir");



        Integer input= Integer.parseInt(scanner.nextLine());

        // primeras validaciones consultar Historiales
        if(input.equals(1)){
            System.out.println("Estas son las piezas disponibles para comprar");
            System.out.println(Inventario.getListadoInventario());


        }
        else if (input.equals(2)){}
        else if(input.equals(3)){}
        else if(input.equals(4)){}
            //obtener mapa de artista
        else if(input.equals(5)){consolacliente= false;}
        else{
            System.out.println("Opción incorrecta vuelva a intentar");
        }

            
        }

        
        



    }

    // consola Admin

    //consola Cajero

    // consola Operador

    public static void RegistroGaleria(Scanner scanner){
        System.out.println("\n¿Qué tipo de usuario es usted?");
        System.out.println("1. Usuario");
        System.out.println("2. Trabajador");

        Integer input= Integer.parseInt(scanner.nextLine());

        if (input== 1){

            // el cliente se registra de manera optima y crea el objeto cliente para almacenarlo
            System.out.println("Por favor Digite su Usuario: ");
            String user =scanner.nextLine();
            System.out.println("Por favor Digite su Contraseña: ");
            Object password = scanner.nextLine();
            Login.RegistrarUsuario(user, password);
            System.out.println("Por favor digite su contacto: ");
            String contacto= scanner.nextLine();
            System.out.println("Por favor digite su cantidad de dinero");
            double Dinero= Double.parseDouble(scanner.nextLine());

            Cliente cliente= new Cliente(contacto, false, user, password, Dinero);
            Galeria.agregarCliente(cliente);
            System.out.println(Galeria.getlistaClientes());

        }
        else if(input== 2){
            System.out.println("Por favor Digite su Usuario");
            String user =scanner.nextLine();
            System.out.println("Por favor Digite su Contraseña");
            Object password = scanner.nextLine();
            Login.RegistrarTrabajador(user, password);
        }
        else{
            System.out.println("\u001B[31mOpción no válida, por favor intente de nuevo\u001B[0m");
        }
    }



    // persistencia Trabajadores y usuarios
    public static void PersistenciaTrabajadoresClientes() throws IOException{
        String nombreArchivo= "ArchivosPersistencia/Registros.txt";
        HashMap<String,Object> Trabajadores=Galeria.getTrabajadores();
        HashMap<String,Object> Usuarios=Login.getlistadoUser();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("=== Registro Trabajadores ===\n");
            for (java.util.Map.Entry<String, Object> entry: Trabajadores.entrySet()){
                String user= entry.getKey();
                String password = (String) entry.getValue();
                writer.write(user + ": ");
                writer.write(password);
                writer.write("\n");
            }
            writer.write("=== Registro Usuarios ===\n");
            for (java.util.Map.Entry<String, Object> entry: Usuarios.entrySet()){
                String user= entry.getKey();
                String password = (String) entry.getValue();
                writer.write(user + ": ");
                writer.write(password);
                writer.write("\n");
            }
        }
    }

    public static void CargarInformacionLogin() throws FileNotFoundException, IOException{
        String nombreArchivo = "ArchivosPersistencia/Registros.txt";
        HashMap<String,Object> Trabajadores=Galeria.getTrabajadores();
        HashMap<String,Object> Usuarios=Login.getlistadoUser();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea; 
            while ((linea = reader.readLine()) != null) {
               switch (linea) {
                case "=== Registro Usuarios ===":
                linea= reader.readLine();
                if(linea != null){

                    String [] partes=linea.split(":",2);
                    String clave = partes[0].trim();
                    String password = partes[1].trim();
                    Usuarios.put(clave, password);
                }
               
                                            
                Login.setListadoUsuario(Usuarios);
                System.out.println(Usuarios); //TODO borrar para entrega Final
                
                break;
                case "=== Registro Trabajadores ===":
                
                    linea= reader.readLine();

                    if (linea != null){
                        String [] partes1=linea.split(":",2);
                        String clave1 = partes1[0].trim();
                        String password1 = partes1[1].trim();
                        Trabajadores.put(clave1, password1);

                    }
                    
                
             
                Galeria.setListadoTrabajadores(Trabajadores);
                System.out.println(Trabajadores); //TODO borrar para entrega Final
                
                break;
                

                    // cargar los clientes
               }
            }
        }
    }
    //persistencia Clientes
    public static void guardarClientes() {
        String archivo= "ArchivosPersistencia/ListaClientes.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write("Contacto/Dinero/Validacion/User/password");
            ArrayList<Cliente> listaclientes=Galeria.getlistaClientes();
            for (Cliente cliente : listaclientes) {
                writer.write(cliente.getContacto() + "," + cliente.getDinero() + "," + cliente.getValidacion()+","
                + cliente.getuser()+","+cliente.getPassword());
                writer.write("\n");
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Ajustar persistencia para mejorar capacidad

    public static void persistencianventario() throws IOException{

        //TODO ajustar persistencia de inventario
        String nombreArchivo= "ArchivosPersistencia/Inventario.txt";
        HashMap<String,Pieza> listadoD= Inventario.getlistadoinventario();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
        writer.write("=== ListadoDisponibles ===\n");
        for (java.util.Map.Entry<String, Pieza> entry:listadoD.entrySet()){
            String clave = entry.getKey();
            Pieza pieza = entry.getValue();
            writer.write(clave + ": ");
            writer.write(pieza.getTitulo()+";"+pieza.getFehca()+";"+
            pieza.getLugarCreacion()+";"+ pieza.getPrecio()+";"+
            pieza.getDisponible()+";"+pieza.getEstado()+";"+pieza.getAutor());

            writer.write("\n");

        }

    }
}
}









