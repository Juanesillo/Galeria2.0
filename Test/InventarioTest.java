package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import InventariosySubasta.Inventario;
import InventariosySubasta.Pieza;

public class InventarioTest {

    private Inventario inventario;

    @BeforeEach
    public void setUp() {
       
        inventario = new Inventario();
    }

    @Test
    public void testAgregarDatos_Exhibida() throws Exception {
    	
    	Pieza piezaExhibida = new Pieza("Piezaaaa", "2023-05-16", "Lugarrr", 800, true, "exhibida", "Anonimo");

        Inventario.AgregarDatos(piezaExhibida);
        
        assertTrue(inventario.exhibidas().containsKey("Piezaaaa"));
        assertEquals(piezaExhibida, inventario.exhibidas().get("Piezaaaa"));
    }

    @Test
    public void testEliminarPieza() throws Exception {
       
        Pieza pieza = new Pieza("Yuca", "2023-06-30", "Neiva", 2000, true, "exhibida", "Crispulo Ponponio");
        Inventario.AgregarDatos(pieza);

        Inventario.eliminarPieza("Yuca");

      
        assertFalse(Inventario.getListadoInventario().containsKey("Yuca"));
    }

    @Test
    public void testAgregarHistorialArtista() throws Exception {
       
        Pieza pieza1 = new Pieza("Monalisa","2024-05-06" , "Italia", 13000, true,"exhibido", "Davinci");
        Pieza pieza2 = new Pieza("Ultima cena","1700-05-06" , "Italia", 8000, true,"bodega", "Davinci");

        Inventario.AgregarDatos(pieza1);
        Inventario.AgregarDatos(pieza2);

        Inventario.AgregarHistorialArtista("Davinci");

        assertTrue(Inventario.getHistorialArtista().containsKey("Davinci"));
        assertEquals(2, Inventario.getHistorialArtista().get("Davinci").size());
    }
}
