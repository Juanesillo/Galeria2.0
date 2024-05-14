package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import InventariosySubasta.Pieza;
import InventariosySubasta.Subasta;
import Trabajadores.Operador;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperadorTest {

    private Operador operador;
    private Subasta subasta;

    @BeforeEach
    public void setUp() {
        
        operador = new Operador("usuario", "contraseña");
        
		subasta = new Subasta();
        
    }

    @Test
    public void testObtenerGanador() {
        // Agregar una pieza ganadora al HashMap
    	Pieza piezaGanadora= new Pieza("Monalisa","2024-05-06" , "Italia", 13000, true,"Bueno", "Davinci");
        operador.ObtenerGanador().put("Luis Rodri", piezaGanadora);

        // Verificar que el ganador junto a la pieza ganadora se haya agregado correctamente
        assertTrue(operador.ObtenerGanador().containsKey("Luis Rodri"));
        assertEquals(piezaGanadora, operador.ObtenerGanador().get("Luis Rodri"));
    }

    @Test
    public void testRegistrarSubasta() {
    	
        // Registrar una subasta con nombre y precio
        operador.registrarSubasta("La Guernica", 1587569);

        // Verificar que la subasta se haya registrado correctamente
        
        assertTrue(subasta.getOfertas().containsKey("La Guernica"));
        assertEquals(1587569, subasta.getOfertas().get("La Guernica").intValue());
    }
}

