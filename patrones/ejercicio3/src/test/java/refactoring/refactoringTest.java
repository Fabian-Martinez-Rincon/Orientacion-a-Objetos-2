package refactoring;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class refactoringTest {

	Pelicula pelicula;
	Usuario usuario;
	Subscripcion subs;
	@BeforeEach
	void setUp() throws Exception{
		subs = new Subscripcion();
		usuario = new Usuario();
		pelicula = new Pelicula(10);
	}
	@Test
	public void testBasico() {
		usuario.setTipoSubscripcion(subs, "Basico");
		assertEquals(10.0, usuario.calcularCostoPelicula(pelicula));
	}
	@Test
	public void testFamilia() {
		usuario.setTipoSubscripcion(subs, "Familia");
		assertEquals(9, usuario.calcularCostoPelicula(pelicula));
	}
	@Test
	public void testPremium() {
		usuario.setTipoSubscripcion(subs, "Premium");
		assertEquals(7.5, usuario.calcularCostoPelicula(pelicula));
	}
}