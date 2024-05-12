package composite;

import java.time.LocalDate;

public class Archivo extends FileSystem{
	private int tamano;

	public Archivo(String nombre, LocalDate fecha, int tamano) {
		super(nombre, fecha);
		this.tamano = tamano;
	}
	public Archivo archivoMasGrande() {
		return this;
	}
	public Archivo archivoMasNuevo() {
		return this;
	}
	public int tamanoTotalOcupado() {
		return this.tamano;
	}
}