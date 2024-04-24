package ar.edu.info.unlp.ejercicioDemo;

abstract class Topografia {
	abstract public double porcentajeAgua();
	
	public Object quienSoy() {
		return this;
	}
	
	public boolean igual(Topografia t) {
		return this.igualAgual(t);
	}
	abstract public boolean igualAgual(Topografia t);
	
	
	
}