package composite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Directorio extends FileSystem {
	private List<FileSystem> files;

	public Directorio(String nombre, LocalDate fecha) {
		super(nombre, fecha);
		this.files = new ArrayList<>();
	}

	public void agregar(FileSystem archivo) {
		this.files.add(archivo);	
	}

	public int tamanoTotalOcupado() {
		return (
			this.files.stream()
			.mapToInt(file -> file.tamanoTotalOcupado())
			.sum()
			) + 32;
	}

	public Archivo archivoMasGrande() {
		return this.files.stream()
			.map(file -> file.archivoMasGrande())
			.max((a1,a2) -> Integer.compare(a1.tamanoTotalOcupado(),a2.tamanoTotalOcupado()))
			.orElse(null);
	}

	public Archivo archivoMasNuevo() {
		return this.files.stream()
			.map(file -> file.archivoMasNuevo())
			.max((a1,a2) -> a1.getFecha().compareTo(a2.getFecha()))
			.orElse(null);
	}
}