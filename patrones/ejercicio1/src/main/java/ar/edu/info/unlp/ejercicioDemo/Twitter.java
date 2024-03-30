package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class Twitter {
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	public void agregarUsuario(Usuario u) {
		this.usuarios.add(u);
	}
	
	public void eliminarUsuario(Usuario u) {
		u.eliminarReTweets();
		this.eliminarReferenciasAlUsuario(u.devolverTweets());
		u.eliminarTweets();
	}
	
	public void eliminarReferenciasAlUsuario(List<Tweet> tweetsEliminar){
		for (Tweet tweet: tweetsEliminar) {
			for (Usuario usuario: usuarios) {
				if (usuario.tieneReTweetsDelTweet(tweet)){
					usuario.eliminarReTweetsReferenciados(tweet);
				}
			}
				
		}
	}
}