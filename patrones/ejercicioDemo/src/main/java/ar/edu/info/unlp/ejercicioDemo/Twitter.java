package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Twitter () {
		
	}
	
	public void registrarUsuario(Usuario u) {
		this.usuarios.add(u);
	}
	
	//public void eliminarUsuario(Usuario u) {
	//	this.usuarios.remove(u);
	//}
	
}
