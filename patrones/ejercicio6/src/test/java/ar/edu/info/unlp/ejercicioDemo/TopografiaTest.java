package ar.edu.info.unlp.ejercicioDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiaTest {
	
	Agua a1;
	Tierra t1;
	Mixta mixto;
	
	@BeforeEach
	void setUp() throws Exception {
		a1 = new Agua();
		t1 = new Tierra();
		mixto = new Mixta(a1, a1, t1, t1);
		
	}
	
    @Test
    public void testPorcentaje() {
    	assertEquals(0.5, mixto.porcentaje());
    }
    
    @Test
    public void testPorcentajeMixto() {
    	mixto.setMixta(mixto);
    	assertEquals(0.5, mixto.porcentaje());
    }
}
