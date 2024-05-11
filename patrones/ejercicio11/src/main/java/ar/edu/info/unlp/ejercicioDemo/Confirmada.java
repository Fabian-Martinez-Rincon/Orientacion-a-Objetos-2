package ar.edu.info.unlp.ejercicioDemo;

public class Confirmada extends Etapa{

	public Confirmada(Proyecto proyecto) {
		super(proyecto);
	}

	void aprobarEtapa() {
	}

	boolean esModificableMargen(double nuevoMargen) {
		return false;
	}


}
