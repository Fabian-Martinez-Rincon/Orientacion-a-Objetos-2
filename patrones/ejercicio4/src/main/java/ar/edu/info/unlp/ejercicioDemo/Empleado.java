package ar.edu.info.unlp.ejercicioDemo;

public abstract class Empleado {
	private String nombre;
	protected double cantidadHijos;
	protected Boolean estaCasado;
	
	public Empleado(String nombre) {
		this.nombre = nombre;
	}
	
	public double calcularSueldo() {
		return this.getBasico() + getAdicional() - getDescuento();
	}
	
	abstract double getBasico();
	abstract double getAdicional();
	
	double getDescuento() {
		return this.getBasico() * 0.13 + this.getAdicional() * 0.05;
	}
	
	public void setCasado(Boolean estaCasado) {
		this.estaCasado = estaCasado;
	}
	
	public void cantidadHijos(double cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

}
