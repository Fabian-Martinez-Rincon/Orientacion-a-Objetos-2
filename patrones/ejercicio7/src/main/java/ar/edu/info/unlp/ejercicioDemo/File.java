package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class File extends FileSystemElement {

    public File(String nombre, int tamanio) {
        super(nombre, tamanio);
    }

    @Override
    public int tamanoTotalOcupado() {
        return this.getTamanio();
    }

    @Override
    public File archivoMasGrande() {
        return this; 
    }

    @Override
    public File archivoMasNuevo() {
        return this; 
    }

    @Override
    public FileSystemElement buscar(String nombre) {
        if (this.getNombre().equals(nombre)) {
            return this;
        }
        return null;
    }

    @Override
    public List<FileSystemElement> buscarTodos(String nombre) {
        List<FileSystemElement> resultados = new ArrayList<>();
        if (this.getNombre().equals(nombre)) {
            resultados.add(this);
        }
        return resultados;
    }

    @Override
    public String listadoDeContenido() {
        return "/" + getNombre() + " (Tamaño: " + getTamanio() + ")\n";
    }
}
