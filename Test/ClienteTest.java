
package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Clientes.Cliente;
import InventariosySubasta.Pieza;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        
        cliente = new Cliente("correoPepito@gmail.com", true, "Pepito", "contraseña", 8000);
    }

    @Test
    public void testCrearSolicitud() {
        // Crear una solicitud de pieza
        cliente.CrearSolicitud("Yuca", "2023-06-30", "Neiva", 2000, true, "Disponible", "Crispulo Ponponio");

        // Verificar solicitud en historiL
        assertTrue(cliente.getHistorial().containsKey("Yuca"));
        assertEquals("Neiva", cliente.getHistorial().get("Yuca").getLugarCreacion());
    }

    @Test
    public void testAgregarCompra() {
        // Crear una pieza comprada
        Pieza piezaComprada = new Pieza("Piezaaaa", "2023-05-16", "Lugarrr", 800, true, "Exhibido", "Anonimo");

        // Agregar la pieza al registro de compras
        cliente.AgregarCompra("Compra1", piezaComprada);

        // Verificar que la compra se haya registrado correctamente
        assertTrue(cliente.getCompras().containsKey("Compra1"));
        assertEquals(800, cliente.getCompras().get("Compra1").getPrecio());
    }

    @Test
    public void testAgregarHistorial() {
        // Crear una pieza comprada
        Pieza piezaComprada = new Pieza("Quiereme", "2023-05-16", "Argentina", 546, true, "Disponible", "Caligari");

        // Agregar la pieza al registro de compras
        cliente.AgregarHistorial("Quiereme", piezaComprada);

        // Verificar que la compra se haya registrado correctamente
        assertTrue(cliente.getHistorial().containsKey("Quiereme"));
        assertEquals(546, cliente.getHistorial().get("Quiereme").getPrecio());
    }
    
}
