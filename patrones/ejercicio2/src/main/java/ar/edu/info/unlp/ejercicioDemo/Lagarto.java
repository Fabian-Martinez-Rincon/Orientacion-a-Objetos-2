package ar.edu.info.unlp.ejercicioDemo;

public class Lagarto extends Jugada{

	@Override
	public String juegaContra(Jugada j) {
		return j.contraLagarto();
	}

	@Override
	public String contraPiedra() {
		return "Es Aplastado";
	}

	@Override
	public String contraPapel() {
		return "Come";
	}

	@Override
	public String contraTijera() {
		return "Es Decapitado";
	}

	@Override
	public String contraLagarto() {
		return "Empata";
	}

	@Override
	public String contraSpock() {
		return "Envenena";
	}

}
