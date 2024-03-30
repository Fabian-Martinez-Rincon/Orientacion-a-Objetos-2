package ar.edu.info.unlp.ejercicioDemo;

public class Piedra extends Jugada{

	@Override
	public String juegaContra(Jugada j) {
		return j.contraPiedra();
	}

	@Override
	public String contraPiedra() {
		return "Empata";
	}

	@Override
	public String contraPapel() {
		return "Es cubierto";
	}

	@Override
	public String contraTijera() {
		return "Aplasta";
	}

	@Override
	public String contraLagarto() {
		return "Aplasta";
	}

	@Override
	public String contraSpock() {
		return "Es Vaporizado";
	}

	

}
