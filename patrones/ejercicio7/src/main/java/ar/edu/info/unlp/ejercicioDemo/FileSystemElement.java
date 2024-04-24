package ar.edu.info.unlp.ejercicioDemo;
import java.util.*;
import java.time.*;

public abstract class FileSystemElement {
	private String nombre;
	private LocalDate fechaCreacion;
	private int tamanio;
	
	public FileSystemElement(String nombre, int tamanio) {
		this.nombre=nombre;
		this.tamanio=tamanio;
		this.fechaCreacion = LocalDate.now();
	}
	
	abstract public int tamanoTotalOcupado();
	abstract public File archivoMasGrande();
	abstract  public File archivoMasNuevo();
	abstract public FileSystemElement buscar(String nombre);
	
	abstract public List<FileSystemElement> buscarTodos(String nombre);
	
	abstract public String listadoDeContenido();
	
	public int getTamanio() {
		return this.tamanio;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}
	
	public void setFechaCreacion(LocalDate fecha) {
		this.fechaCreacion = fecha;
	}
}
