package ar.edu.info.unlp.ejercicioDemo;

public abstract class Jugada {
	public abstract String juegaContra(Jugada j);
	public abstract String contraPiedra();
	public abstract String contraPapel();
	public abstract String contraTijera();
	public abstract String contraLagarto();
	public abstract String contraSpock();
}
