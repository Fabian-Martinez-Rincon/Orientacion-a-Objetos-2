package composite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaPlayerTest {
	Archivo archivoChico, archivoGrande;
	Directorio directorio, directorioCompuesto;
	
	@BeforeEach
	void setUp() throws Exception{
		archivoChico = new Archivo("notas.txt", LocalDate.of(2000, 2, 20), 10);
		archivoGrande = new Archivo("apuntes.txt", LocalDate.of(2010, 2, 20), 50);
		
		directorio = new Directorio("Carpeta1", LocalDate.now());
		directorio.agregar(archivoChico);
		directorio.agregar(archivoGrande);
		
		directorioCompuesto = new Directorio("CarpetaCompuesta", LocalDate.now());
		directorioCompuesto.agregar(directorio);
	}
	
	@Test
	public void testEspacio() {
		assertEquals((10 + 50 + 32), directorio.tamanoTotalOcupado());
		assertEquals((10 + 50 + 32 + 32), directorioCompuesto.tamanoTotalOcupado());
		assertEquals(archivoGrande, directorioCompuesto.archivoMasGrande());
		assertEquals(archivoGrande, directorioCompuesto.archivoMasNuevo());
	}
}
