package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Clientes.Cliente;
import InventariosySubasta.Pieza;
import Trabajadores.Cajero;


public class CajeroTest {

	    private Cajero cajero;
	    private Cliente cliente;

	    @BeforeEach
	    public void setUp() {
	        // Configuración inicial antes de cada prueba
	        cajero = new Cajero("usuario", "contraseña");
	        cliente = new Cliente("3002458796", true, "usuario", 12345, 800); // Crear un cliente con $500
	    }

	    @Test
	    public void testRegistrarCompra() {
	        // Registrar una compra en registroCompras
	        Cajero.RegistrarCompra("La Silla", 100);

	        // Verificar que la compra se haya registrado en el hash de cmopras
	        assertTrue(Cajero.getRegistroCompras().containsKey("La Silla"));
	        assertEquals(100, Cajero.getRegistroCompras().get("La Silla"));
	    }

	    @Test
	    public void testValidarCompra_SuficienteDinero() {
	        
	    	Pieza pieza= new Pieza("La fuente","2022-01-08" , "UK", 790, true,"Bueno", "Marcele");
	        
	    // Validar la compra con suficiente dinero
	        assertTrue(cajero.validarCompra(pieza, cliente));
	     // Dinero restante
	        assertEquals(10, cliente.getDinero()); 
	    }

	    @Test
	    public void testValidarCompra_InsuficienteDinero() {
	     
	    	Pieza pieza= new Pieza("Guanabana","2024-05-06" , "Colombia", 1000, true,"Bueno", "Davinci");

	        // Validar la compra con dinero insuficiente
	        assertFalse(cajero.validarCompra(pieza, cliente));
	        // Dinero igual
	        assertEquals(800, cliente.getDinero()); 
	    }
	}



