package ar.edu.unlp.info.oo2.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BibliotecaTest {

	Biblioteca biblioteca;
	Socio socio1;
	Socio socio2;
	
	@BeforeEach
	void setUp() throws Exception{
		biblioteca = new Biblioteca();
		socio1 = new Socio("Messi","messi@gmail.com","10");
		socio2 = new Socio("Ronaldo","ronaldo@gmail.com","7");
		biblioteca.agregarSocio(socio1);
	}
	
	@Test
	public void testExportar() {
		String separator = System.lineSeparator();
		assertEquals("[" + separator +"\t{" + separator
				+ "\t\t\"nombre\": \"" + "Messi" + "\"," + separator
				+ "\t\t\"email\": \"" + "messi@gmail.com" + "\"," + separator
				+ "\t\t\"legajo\": \"" + "10" + "\"" + separator
				+ "\t}"+ separator + "]", biblioteca.exportarSocios());	
	}
}
