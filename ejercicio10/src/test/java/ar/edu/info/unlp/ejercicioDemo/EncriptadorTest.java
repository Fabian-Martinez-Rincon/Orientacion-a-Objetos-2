package ar.edu.info.unlp.ejercicioDemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EncriptadorTest {
    
    ConexionSegura conexionSegura;
    Encriptador encriptadorBlow, encriptadorRSA, encriptadorRC4;
    Mensajero mensajero;
    
    @BeforeEach
    void setUp() throws Exception {    	
    	
        encriptadorBlow = new EncriptadorBlowfish();
        encriptadorRSA = new EncriptadorRSA();
        encriptadorRC4 = new EncriptadorRC4();
        
        conexionSegura = new ConexionSegura(encriptadorBlow);
        mensajero = new Mensajero(conexionSegura);
    }
    
    @Test
    public void testEnviar() {
    	String mensaje = "vivan las drogas";
    	
        assertEquals("Blowfish: vivan las drogas", mensajero.enviar(mensaje));
        
        conexionSegura.setEncriptador(encriptadorRSA);
        assertEquals("RSA: vivan las drogas", mensajero.enviar(mensaje));
        
        conexionSegura.setEncriptador(encriptadorRC4);
        assertEquals("RC4: vivan las drogas", mensajero.enviar(mensaje));
        
    }
}