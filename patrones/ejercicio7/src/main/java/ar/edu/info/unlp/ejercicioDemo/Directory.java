package ar.edu.info.unlp.ejercicioDemo;

import java.util.*;

public class Directory extends FileSystemElement{
	private List<FileSystemElement> elementos;
	
	public Directory(String nombre, int tamanio) {
		super(nombre, tamanio);
		this.elementos = new ArrayList<>();
	}

	@Override
	public int tamanoTotalOcupado() {
		return this.elementos.stream()
				.mapToInt(elemento->elemento.tamanoTotalOcupado())
				.sum();
	}

	@Override
	public File archivoMasGrande() {
	    return this.elementos.stream()//Posible envidia de atributos
	            .map(elemento -> elemento.archivoMasGrande())
	            .max(Comparator.comparingInt(File::getTamanio))
	            .orElse(null);
	}
	@Override
	public File archivoMasNuevo() {
	    return this.elementos.stream()
	        .map(elemento -> elemento.archivoMasNuevo())
	        .max(Comparator.comparing(File::getFechaCreacion))
	        .orElse(null);
	}


	@Override
	public FileSystemElement buscar(String nombre) {
	    if (this.getNombre().equals(nombre)) {
	        return this;
	    }
	    for (FileSystemElement elemento : elementos) {
	        FileSystemElement resultado = elemento.buscar(nombre);
	        if (resultado != null) {
	            return resultado;
	        }
	    }
	    return null;
	}


	@Override
	public List<FileSystemElement> buscarTodos(String nombre) {
	    List<FileSystemElement> encontrados = new ArrayList<>();

	    if (this.getNombre().equals(nombre)) {
	        encontrados.add(this);
	    }

	    for (FileSystemElement elemento : elementos) {
	        encontrados.addAll(elemento.buscarTodos(nombre));
	    }

	    return encontrados;
	}
	
	public void addElement(FileSystemElement elemento) {
		this.elementos.add(elemento);
	}


	 @Override
	    public String listadoDeContenido() {

	        return listadoDeContenidoRecursivo("");
	    }

	    private String listadoDeContenidoRecursivo(String pathAcumulado) {
	        String pathCompleto = pathAcumulado + "/" + getNombre();
	        StringBuilder listado = new StringBuilder(pathCompleto + "\n");
	        
	        for (FileSystemElement elemento : elementos) {
	            listado.append(elemento instanceof Directory ?
	                ((Directory) elemento).listadoDeContenidoRecursivo(pathCompleto) :
	                pathCompleto + "/" + elemento.getNombre() + "\n");
	        }
	        
	        return listado.toString();
	    }


}
