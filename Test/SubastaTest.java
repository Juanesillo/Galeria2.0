package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import InventariosySubasta.Pieza;
import InventariosySubasta.Subasta;

public class SubastaTest {

    private Subasta subasta;

    @BeforeEach
    public void setUp() {
       
        subasta = new Subasta();
    }

    @Test
    public void testIniciarSubasta_DiaPar() {
        
        subasta.setIniciar(false); 
        subasta.getPieza();
        
        // Iniciar la subasta
        HashMap<Pieza, Integer> sub = subasta.iniciarSubasta();

        assertTrue(subasta.GetIniciar());
        assertNotNull(sub);
        assertFalse(sub.isEmpty());
    }

    @Test
    public void testRegistroOfertas() {
        // Registrar una oferta
        Subasta.Registro("Pepe", 85469);
        
        assertTrue(subasta.getOfertas().containsKey("Pepe"));
        assertEquals(85469, subasta.getOfertas().get("Pepe"));
    }
}
