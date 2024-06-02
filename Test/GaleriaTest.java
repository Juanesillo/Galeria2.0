package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Clientes.Cliente;
import Galeria.Galeria;
import InventariosySubasta.Pieza;
import LoginRegistro.userregister;

public class GaleriaTest {

    private Galeria galeria;

    @BeforeEach
    public void setUp() {
        // Configuración inicial antes de cada prueba
        galeria = new Galeria();
    }

    @Test
    public void testRegistrarTrabajador() {
        
        userregister.RegistrarTrabajador("Jack Slay", "9845632");

        // Verificar que el trabajador se haya registrado correctamente
        assertTrue(userregister.getListadoTrabajadores().containsKey("Jack Slay"));
        assertEquals("9845632", userregister.getListadoTrabajadores().get("Jack Slay"));
    }

    @Test
    public void testAgregarCliente() {

        Cliente cliente = new Cliente("correoPepito@gmail.com", true, "Pepito", "contraseña", 8000);

        Galeria.agregarCliente(cliente);

        assertTrue(Galeria.getlistaClientes().contains(cliente));
    }

    @Test
    public void testSolicitudPieza() {
        
        Pieza pieza = new Pieza("Yuca", "2023-06-30", "Neiva", 2000, true, "Disponible", "Crispulo Ponponio");

        Galeria.SolicitudPieza("SolicitudYuca", pieza);

        assertTrue(Galeria.getsolicituPiez().containsKey("SolicitudYuca"));
        assertEquals(pieza, Galeria.getsolicituPiez().get("SolicitudYuca"));
    }
    // funciona :)
}