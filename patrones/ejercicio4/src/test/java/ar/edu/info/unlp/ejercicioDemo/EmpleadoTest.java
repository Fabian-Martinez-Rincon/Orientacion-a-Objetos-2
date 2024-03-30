package ar.edu.info.unlp.ejercicioDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EmpleadoTest {
	
	Pasante pasante;
	Planta planta;
	Temporal temporal;
	
	@BeforeEach
	void setUp() throws Exception {
		temporal = new Temporal("Temporal");
		pasante = new Pasante("Pasante");
		planta = new Planta("Planta");		
	}
	
    @Test
    public void testTemporal() {
    	temporal.setCantidadHoras(10);
    	temporal.setCasado(true);
    	temporal.cantidadHijos(1);
    	
        assertEquals(23000, temporal.getBasico());
        assertEquals(7000, temporal.getAdicional());
        assertEquals((23000 * 0.13) + (7000 * 0.05), temporal.getDescuento());
    }
    
    @Test
    public void testPasante() {
    	pasante.setExamenesRendidos(10);
    	
        assertEquals(20000, pasante.getBasico());
        assertEquals(20000, pasante.getAdicional());
        assertEquals((20000 * 0.13) + (20000 * 0.05), pasante.getDescuento());
    }
    
    @Test
    public void testPlanta() {
    	planta.setCasado(true);
    	planta.cantidadHijos(1);
    	planta.setAntiguedad(1);
    	
        assertEquals(50000, planta.getBasico());
        assertEquals(9000, planta.getAdicional());
        assertEquals((50000 * 0.13) + (9000 * 0.05), planta.getDescuento());
    }
}
