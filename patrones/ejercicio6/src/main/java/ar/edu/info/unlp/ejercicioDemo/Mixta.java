package ar.edu.info.unlp.ejercicioDemo;

import java.util.*;

public class Mixta extends Topografia{
	
	private List<Topografia> componentes = new ArrayList<>();
	
	
	public Mixta(Topografia t1, Topografia t2, Topografia t3, Topografia t4) {
		this.componentes.add(t1);
		this.componentes.add(t2);
		this.componentes.add(t3);
		this.componentes.add(t4);
	}

	@Override
	public double porcentajeAgua() {
		
		return this.componentes.stream()
				.mapToDouble(componente -> componente.porcentajeAgua())
				.sum()
				/
				this.componentes.size();
	}

	
	public boolean igual(Topografia t) {
		return this.igualAgual(t);
	}
	
	@Override
	public boolean igualAgual(Topografia t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
