package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Galeria.Galeria;
import LoginRegistro.Login;

public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        
        login = new Login("Carlos Perez", "2148965");
    }

    @Test
    public void testValidarUser_UsuarioValido() {
       
        Login.RegistrarUsuario("Carlos Perez", "2148965");

        
        assertTrue(Login.ValidarUser("Carlos Perez", "2148965"));
    }

    @Test
    public void testValidarUser_UsuarioInvalido() {
        
        assertFalse(Login.ValidarUser("Camila Rojas", "2197965"));
    }

    @Test
    public void testRegistrarTrabajador() {
       
        Login.RegistrarTrabajador("Operador-Rodrido Gomez", "85471684");

        assertTrue(Galeria.getListadoTrabajadores().containsKey("Operador-Rodrido Gomez"));
        assertEquals("85471684", Galeria.getListadoTrabajadores().get("Operador-Rodrido Gomez"));
    }
}
