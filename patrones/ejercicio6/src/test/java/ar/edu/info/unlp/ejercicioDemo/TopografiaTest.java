package ar.edu.info.unlp.ejercicioDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiaTest {
	
	Topografia a1;
	Topografia t1;
	Mixta mixto,mixto2,mixto3;
	
	@BeforeEach
	void setUp() throws Exception {
		a1 = new Agua();
		t1 = new Tierra();
		
		mixto = new Mixta(a1, a1, t1, t1);
		mixto2 = new Mixta(a1, a1, t1, mixto);
		mixto3 = new Mixta(a1, a1, t1, t1);
	}
	
    @Test
    public void testPorcentaje() {
    	assertEquals(1, a1.porcentajeAgua());
    	assertEquals(0, t1.porcentajeAgua());
    	assertEquals(0.5, mixto.porcentajeAgua());
    	assertEquals(0.625, mixto2.porcentajeAgua());
    }
    
    @Test
    public void testIgualdad() {
    	assertTrue(a1.igual(a1));
    	//assertEquals(0, t1.porcentajeAgua());
    	//assertEquals(0.5, mixto.porcentajeAgua());
    	//assertEquals(0.625, mixto2.porcentajeAgua());
    }
    
}
