package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Galeria.Galeria;
import LoginRegistro.userregister;

public class LoginTest {

    private userregister login;

    @BeforeEach
    public void setUp() {
        
        login = new userregister("Carlos Perez", "2148965");
    }

    @Test
    public void testValidarUser_UsuarioValido() {
       
        userregister.RegistrarUsuario("Carlos Perez", "2148965");

        
        assertTrue(userregister.ValidarUser("Carlos Perez", "2148965"));
    }

    @Test
    public void testValidarUser_UsuarioInvalido() {
        
        assertFalse(userregister.ValidarUser("Camila Rojas", "2197965"));
    }

    @Test
    public void testRegistrarTrabajador() {
       
        userregister.RegistrarTrabajador("Operador-Rodrido Gomez", "85471684");

        assertTrue(userregister.getListadoTrabajadores().containsKey("Operador-Rodrido Gomez"));
        assertEquals("85471684",userregister.getListadoTrabajadores().get("Operador-Rodrido Gomez"));
    }
}
