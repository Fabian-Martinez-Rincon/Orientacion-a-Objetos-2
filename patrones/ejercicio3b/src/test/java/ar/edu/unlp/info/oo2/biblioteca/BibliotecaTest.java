package ar.edu.unlp.info.oo2.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class BibliotecaTest {

	Biblioteca biblioteca;
	Socio socio1;
	Socio socio2;
	Adapter adapter;
	JSONParser parser;
	
	@BeforeEach
	void setUp() throws Exception{
		biblioteca = new Biblioteca();
		socio1 = new Socio("Messi","messi@gmail.com","10");
		socio2 = new Socio("Ronaldo","ronaldo@gmail.com","7");
		adapter = new Adapter();
		
		biblioteca.agregarSocio(socio1);
		parser = new JSONParser();
	}
	
	@Test
	public void testExportarJson() throws ParseException {
		biblioteca.setExporter(adapter);
		String separator = System.lineSeparator();
		
		String socio = "[" + separator +"\t{" + separator
			+ "\t\t\"nombre\": \"" + "Messi" + "\"," + separator
			+ "\t\t\"email\": \"" + "messi@gmail.com" + "\"," + separator
			+ "\t\t\"legajo\": \"" + "10" + "\"" + separator
			+ "\t}"+ separator + "]";
		
		assertEquals("[{\"legajo\":\"10\",\"nombre\":\"Messi\",\"email\":\"messi@gmail.com\"}]", 
				biblioteca.exportarSocios());

		assertEquals(parser.parse(socio), parser.parse(biblioteca.exportarSocios()));
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
