package ar.edu.info.unlp.ejercicioDemo;

public class Tierra extends Topografia{

	@Override
	public double porcentajeAgua() {
		return 0;
	}

	@Override
	public boolean igualAgual(Topografia t) {
		return false;
	}
}
