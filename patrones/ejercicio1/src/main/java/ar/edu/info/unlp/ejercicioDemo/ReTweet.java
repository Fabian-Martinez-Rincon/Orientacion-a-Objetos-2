package ar.edu.info.unlp.ejercicioDemo;

public class ReTweet {
	private Tweet origen = null;;
	
	public ReTweet(Tweet origen) {
		this.origen = origen;		
	}
	
	public boolean esOrigen(Tweet destino) {
		return this.origen.equals(destino);
	}
}