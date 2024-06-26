package strategy;

import java.util.*;

public class Decodificador {
	private List<Pelicula> grilla;
	private List<Pelicula> reproducidas;
	private Sugerencia criterioSugerencia;
	
	public Decodificador() {
		this.grilla = new ArrayList<>();
		this.reproducidas = new ArrayList<>();
		this.criterioSugerencia = new SugerenciaNovedad();
	}
	public void agregarAGrilla(Pelicula pelicula) { this.grilla.add(pelicula); }
	public void agregarReproducida(Pelicula pelicula) { this.reproducidas.add(pelicula);}
	public void setCriterioSugerencia(Sugerencia sugerencia) { this.criterioSugerencia = sugerencia; }
	public List<Pelicula> obtenerSugerencias() {
		return this.criterioSugerencia.obtenerSugerencias(this);
	}
	public List<Pelicula> getGrilla() { return this.grilla; }
	public List<Pelicula> getReproducidas() { return this.reproducidas; }
}
