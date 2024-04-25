package ar.edu.info.unlp.ejercicioDemo;

import java.time.temporal.ChronoUnit;

public class Construccion extends Etapa{

	public Construccion(Proyecto proyecto) {
		super(proyecto);
	}

	void aprobarEtapa() {
		if (this.getProyecto().calcularPrecio() > 0) {
			this.getProyecto().setEtapa(
					new EnEvaluacion(this.getProyecto())
					);
		}
	}

	public boolean esModificableMargen(double nuevoMargen) {
		if (nuevoMargen >= 0.08 && nuevoMargen<= 0.10) {
			return true;
		}
		return false;
	}


}
