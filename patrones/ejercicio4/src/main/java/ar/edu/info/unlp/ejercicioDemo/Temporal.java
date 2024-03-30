package ar.edu.info.unlp.ejercicioDemo;

public class Temporal extends Empleado{
	private double cantidadHoras;
	
	public Temporal(String nombre) {
		super(nombre);
	}  

	public void setCantidadHoras(double horas) {
		this.cantidadHoras = horas;
	}
	
	@Override
	double getBasico() {
		return 20000 + (this.cantidadHoras * 300);
	}

	@Override
	double getAdicional() {
		if (this.estaCasado) {
			return 5000 + (2000 * this.cantidadHijos);
		}
		return 2000 * this.cantidadHijos;
		
	}
}
