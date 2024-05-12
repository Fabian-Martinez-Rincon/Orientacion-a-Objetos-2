package template;

public class Pasante extends Empleado {
	private int cantidadExamen;

	public Pasante(int cantidadHijos, boolean casado, int cantidadExamen) {
		super(cantidadHijos, casado);
		this.cantidadExamen = cantidadExamen;
	}

	public double sueldoBasico() {
		return 20000;
	}

	public double sueldoAdicional() {
		return this.cantidadExamen * 2000;
	}
}