package ar.edu.info.unlp.ejercicioDemo;

public class EnEvaluacion extends Etapa{

	public EnEvaluacion(Proyecto proyecto) {
		super(proyecto);
	}

	void aprobarEtapa() {
		this.getProyecto().setEtapa(new Confirmada(this.getProyecto()));
	}

	@Override
	boolean esModificableMargen(double nuevoMargen) {
		if (nuevoMargen >= 0.11 && nuevoMargen <= 0.15) {
			
		}
		return false;
	}



}
