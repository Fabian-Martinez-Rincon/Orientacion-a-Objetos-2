package ar.edu.info.unlp.ejercicioDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaTest {
	
	Piedra piedra;
	Papel papel;
	Tijera tijera;
	Lagarto lagarto;
	Spock spock;
	
	@BeforeEach
	void setUp() throws Exception {
		piedra = new Piedra();
		papel = new Papel();
		tijera = new Tijera();
		lagarto = new Lagarto();
		spock = new Spock();
	}
	
    @Test
    public void testNombreCompleto() {
        assertEquals("Se Rompe", piedra.juegaContra(tijera));
        assertEquals("Cubre", piedra.juegaContra(papel));
        assertEquals("Empata", piedra.juegaContra(piedra));
        assertEquals("Es Aplastado", piedra.juegaContra(lagarto));
        assertEquals("Vaporiza", piedra.juegaContra(spock));
    }
}
