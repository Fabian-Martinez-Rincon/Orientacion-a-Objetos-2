package ar.edu.info.unlp.ejercicioDemo;

public class Papel extends Jugada{

	@Override
	public String juegaContra(Jugada j) {
		return j.contraPapel();
	}

	@Override
	public String contraPiedra() {
		return "Cubre";
	}

	@Override
	public String contraPapel() {
		return "Empata";
	}

	@Override
	public String contraTijera() {
		return "Es Cortado";
	}

	@Override
	public String contraLagarto() {
		return "Es Comido";
	}

	@Override
	public String contraSpock() {
		// TODO Auto-generated method stub
		return null;
	}
	


	

}
