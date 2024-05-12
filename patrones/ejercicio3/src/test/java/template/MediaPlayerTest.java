package template;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaPlayerTest {
	Empleado pasante;
	Empleado planta;
	Empleado temporario;
	
	@BeforeEach
	void setUp() throws Exception{
		pasante = new Pasante(10, false, 10);
		planta = new Planta(10, true, 10);
		temporario = new Temporario(10, false, 10);
	}
	@Test
	public void testSueldos() {
		assertEquals(27400.0,pasante.sueldo());
		assertEquals(66000.0,planta.sueldo());
		assertEquals(30010.0,temporario.sueldo());
	}
}
