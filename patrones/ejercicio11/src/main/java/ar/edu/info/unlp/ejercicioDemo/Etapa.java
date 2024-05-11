package ar.edu.info.unlp.ejercicioDemo;

import java.time.temporal.ChronoUnit;

public abstract class Etapa {
	private Proyecto proyecto;
	
	public Etapa(Proyecto proyecto) {
		this.proyecto=proyecto;
	}
	
	public Proyecto getProyecto() {
		return this.proyecto;
	}
	
	
    abstract void aprobarEtapa();
    abstract boolean esModificableMargen(double nuevoMargen);
}
