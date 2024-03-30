package ar.edu.info.unlp.ejercicioDemo;

public class Tijera extends Jugada{

	@Override
	public String juegaContra(Jugada j) {
		return j.contraTijera();
	}

	@Override
	public String contraPiedra() {
		return "Se Rompe";
	}

	@Override
	public String contraPapel() {
		return "Corta";
	}

	@Override
	public String contraTijera() {
		return "Empata";
	}

	@Override
	public String contraLagarto() {
		return "Envenena";
	}

	@Override
	public String contraSpock() {
		return "Es Rompido :c";
	}

	

}
