package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import InventariosySubasta.Pieza;
import InventariosySubasta.Subasta;

public class SubastaTest {


   

    @Test
    public void testIniciarSubasta_DiaPar() {
        
        
        Subasta.getPieza();
        
        // Iniciar la subasta
        HashMap<Pieza, Integer> sub = (HashMap<Pieza, Integer>) Subasta.getSubasta();

       
        assertNotNull(sub);
        assertFalse(sub.isEmpty());
    }

    @Test
    public void testRegistroOfertas() {
        // Registrar una oferta
        Subasta.Registro("Pepe", 85469);
        
        assertTrue(Subasta.getOfertas().containsKey("Pepe"));
        assertEquals(85469, Subasta.getOfertas().get("Pepe"));
    }
}
