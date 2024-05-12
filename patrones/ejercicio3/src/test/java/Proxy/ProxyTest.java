package Proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.*;

import org.junit.jupiter.api.*;


public class ProxyTest {
	DatabaseAcess base;
	DatabaseProxy proxy;
	List<String> pelis_id1 = Arrays.asList("Spiderman", "Marvel");
	List<String> pelis_id2 = Arrays.asList("Batman", "DC comics");
	List<String> agregadas = Arrays.asList("Rocky", "Rambo");
	
	
	@BeforeEach
	void setUp() throws Exception{
		base = new DatabaseRealAccess();
		proxy = new DatabaseProxy(base);
	}
	
	@Test
	public void testSinProxy() {		
		assertEquals(pelis_id1, base.getSearchResults("select * from comics where id=1"));
		assertEquals(pelis_id2, base.getSearchResults("select * from comics where id=2"));
		base.insertNewRow(agregadas);
		assertEquals(agregadas, base.getSearchResults("select * from comics where id=3"));
	}
	
	@Test
	public void testConProxy() {
	    Throwable exception = assertThrows(RuntimeException.class, () -> {
	        proxy.getSearchResults("select * from comics where id=1");
	    });
	    
	    assertEquals("access denied", exception.getMessage());
	    
	    proxy.logIn();
	    assertEquals(pelis_id1, base.getSearchResults("select * from comics where id=1"));
		assertEquals(pelis_id2, base.getSearchResults("select * from comics where id=2"));
		base.insertNewRow(agregadas);
		assertEquals(agregadas, base.getSearchResults("select * from comics where id=3"));
	}
}
