package state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExcursionTest {
	Excursion excursion;
	Usuario usuario;
	
	@BeforeEach
	void setUp() throws Exception{
		usuario = new Usuario("Fabian", "Martinez", "fabian@gmail.com");
		excursion = new Excursion("Viaje", 
				LocalDate.of(2000, 1, 1), 
				LocalDate.of(2000,2,1), "La Ciudad", 100, 3, 6);
	}
	@Test
	public void testExcursion() {
		System.out.print(excursion.obtenerInformacion());
		excursion.inscribir(usuario);
		excursion.inscribir(usuario);
		excursion.inscribir(usuario);
		assertEquals(3, excursion.getInscriptos().size());
		System.out.println();System.out.println();
		System.out.print(excursion.obtenerInformacion());
		
		excursion.inscribir(usuario);
		excursion.inscribir(usuario);
		excursion.inscribir(usuario);
		assertEquals(6, excursion.getInscriptos().size());
		
		excursion.inscribir(usuario);
		assertEquals(1, excursion.getEnEspera().size());
		System.out.println();System.out.println();
		System.out.print(excursion.obtenerInformacion());
	}
}