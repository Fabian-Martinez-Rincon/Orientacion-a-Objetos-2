package strategy;

import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaSimilaridad extends Sugerencia {
	public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
		return decodificador.getReproducidas().stream()
				.map(pelicula -> pelicula.getPeliculasSimilares()).flatMap(lista -> lista.stream())
				.distinct()
				.collect(Collectors.toList());
	} 
}