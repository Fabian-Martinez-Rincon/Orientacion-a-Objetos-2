package ar.edu.info.unlp.ejercicioDemo;

public class Cancelada extends Etapa{

	public Cancelada(Proyecto proyecto) {
		super(proyecto);
		// TODO Auto-generated constructor stub
	}

	@Override
	void aprobarEtapa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean esModificableMargen(double nuevoMargen) {
		// TODO Auto-generated method stub
		return false;
	}

}
