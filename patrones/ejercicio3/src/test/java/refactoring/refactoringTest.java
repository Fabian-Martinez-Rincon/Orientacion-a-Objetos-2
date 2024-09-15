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
	@BeforeEach
	void setUp() throws Exception{
		usuario = new Usuario();
		pelicula = new Pelicula(10);
	}
	@Test
	public void testBasico() {
		usuario.setTipoSubscripcion("Basico");
		assertEquals(110, usuario.calcularCostoPelicula(pelicula));
	}
	@Test
	public void testPremium() {
		usuario.setTipoSubscripcion("Premium");
		assertEquals(-90, usuario.calcularCostoPelicula(pelicula));
	}
}