package ar.edu.info.unlp.ejercicioDemo;

public class Planta extends Empleado{
	private double antiguedad;
	
	
	public Planta(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public void setAntiguedad(double antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	@Override
	double getBasico() {
		return 50000;
	}

	@Override
	double getAdicional() {
		double total = 0;
		if (this.estaCasado) {
			total = total + 5000;
		}
		return total + (2000 * this.cantidadHijos) + (2000 * this.antiguedad);  
		
	}
}
