package ar.edu.info.unlp.ejercicioDemo;

public class Spock extends Jugada{

	@Override
	public String juegaContra(Jugada j) {
		return j.contraSpock();
	}

	@Override
	public String contraPiedra() {
		return "Vaporiza";
	}

	@Override
	public String contraPapel() {
		return "Desaprueba";
	}

	@Override
	public String contraTijera() {
		return "Rompe";
	}

	@Override
	public String contraLagarto() {
		return "Es Envenenado";
	}

	@Override
	public String contraSpock() {
		return "Empata";
	}



}
