package ConsolaPruebas;

import Clientes.Cliente;
import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;
import Trabajadores.Administrador;

public class consolap {

    public static void main(String[] args) throws Exception {
       
        Pieza pieza= new Pieza("prueba","2024-05-06" , "Bogotá", 13000, false,"Bueno", "Davinci");

        Cliente cliente= new Cliente("Prueba", false, "ClienteP", "P",13000);
        cliente.AgregarHistorial(pieza.getTitulo(),pieza);

        System.out.println(cliente.getHistorial());
        Administrador.RegistrarPieza(cliente);

        System.out.println(Inventario.getListadoInventario().size());
    }

}
