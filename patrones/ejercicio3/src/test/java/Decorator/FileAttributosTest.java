package Decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileAttributosTest {
	File file;
	AspectName name;
	
	@BeforeEach
	void setUp() throws Exception{
		file = new File("notas", ".txt", 10, LocalDate.of(2000, 1, 1), LocalDate.of(2024, 05, 12), "Lectura");
		name = new AspectName(file);
	}
	
	@Test
	public void testExcursion() {
		assertEquals("Datos del archivo: ", file.prettyPrint());
		assertEquals("Datos del archivo: Nombre: notas", name.prettyPrint());

	}
}