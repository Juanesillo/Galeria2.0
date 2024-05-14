package Test;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Clientes.Cliente;
import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;
import Trabajadores.Administrador;

public class AdministradorTest {
	
    // beforeEach antes para hacer prubeas
	@Test
    public void testRegistrarPieza() throws Exception {
     
        Pieza pieza= new Pieza("prueba","2024-05-06" , "Bogotá", 13000, false,"Bueno", "Davinci");
        Cliente cliente= new Cliente("Prueba", false, "ClienteP", "P",13000);
        cliente.AgregarHistorial(pieza.getTitulo(),pieza);
        Administrador.RegistrarPieza(cliente);

        // validar que se registra la pieza en el listado del inventario
        assertTrue(Inventario.getListadoInventario().size()==1);
        // validar otras listas
        
    

   


    }

   
}
