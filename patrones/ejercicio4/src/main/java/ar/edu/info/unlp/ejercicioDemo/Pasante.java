package ar.edu.info.unlp.ejercicioDemo;

public class Pasante extends Empleado{
	private double examenesRendidos;
	
	public Pasante(String nombre) {
		super(nombre);
	}

	@Override
	double getBasico() {
		return 20000;
	}

	@Override
	double getAdicional() {
		return 2000 * this.examenesRendidos;
	}
	
	public void setExamenesRendidos(double cantidadExamenes) {
		this.examenesRendidos = cantidadExamenes;
	}

}
