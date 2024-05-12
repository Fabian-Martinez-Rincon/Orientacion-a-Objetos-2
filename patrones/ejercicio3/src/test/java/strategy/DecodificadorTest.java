package strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecodificadorTest {
	Decodificador decodificador;
	Pelicula rocky1, rocky2, rocky3, rocky4, rocky5, terminator1, terminator2, terminator3;
	Sugerencia novedad, puntaje, similaridad;
	
	@BeforeEach
	void setUp() throws Exception{
		rocky1 = new Pelicula("Rocky 1", 10, Year.of(2000));
		rocky2 = new Pelicula("Rocky 2", 9, Year.of(2001));
		rocky3 = new Pelicula("Rocky 3", 8, Year.of(2002));
		rocky4 = new Pelicula("Rocky 4", 7, Year.of(2003));
		rocky5 = new Pelicula("Rocky 5", 6, Year.of(2004));
		
		//Se podria establecer la similitud con cada pelicula pero es mucho
		//Se hace con rocky2 porque busca las mimilares con las reproducidas
		rocky2.establecerSimilitud(rocky1);
		rocky2.establecerSimilitud(rocky3);
		rocky2.establecerSimilitud(rocky4);
		rocky2.establecerSimilitud(rocky5);
		
		terminator1 = new Pelicula("Terminator1", 1, Year.of(2020));
		terminator2 = new Pelicula("Terminator2", 2, Year.of(2021));
		terminator3 = new Pelicula("Terminator3", 3, Year.of(2022));
		
		decodificador = new Decodificador();
		decodificador.agregarAGrilla(rocky1);
		decodificador.agregarAGrilla(rocky2);
		decodificador.agregarAGrilla(rocky3);
		decodificador.agregarAGrilla(rocky4);
		decodificador.agregarAGrilla(rocky5);
		decodificador.agregarAGrilla(terminator1);
		decodificador.agregarAGrilla(terminator2);
		decodificador.agregarAGrilla(terminator3);
		
		decodificador.agregarReproducida(rocky2);
		decodificador.agregarReproducida(rocky4);
	}
	@Test
	public void testSugerenciaNovedad() {
		List<Pelicula> ultimas3 = new ArrayList<>();
		ultimas3.add(terminator3);
		ultimas3.add(terminator2);
		ultimas3.add(terminator1);
		assertEquals(ultimas3, decodificador.obtenerSugerencias());
	}
	@Test
	public void testSugerenciaPuntaje() {
		puntaje = new SugerenciaPuntaje();
		decodificador.setCriterioSugerencia(puntaje);
		List<Pelicula> masPuntaje = new ArrayList<>();
		masPuntaje.add(rocky1);
		masPuntaje.add(rocky3);
		masPuntaje.add(rocky5);
		assertEquals(masPuntaje, decodificador.obtenerSugerencias());
	}
	
	@Test
	public void testSugerenciaSimilaridad() {
		
		similaridad = new SugerenciaSimilaridad();
		decodificador.setCriterioSugerencia(similaridad);
		//Son las 3 similares sin reproducir
		List<Pelicula> similaresRocky = new ArrayList<>();
		similaresRocky.add(rocky1);
		similaresRocky.add(rocky3);
		similaresRocky.add(rocky5);
		assertEquals(similaresRocky, decodificador.obtenerSugerencias());
	}
}