package template;

public class Planta extends Empleado{
	private int aniosAntiguedad;

	public Planta(int cantidadHijos, boolean casado, int aniosAntiguedad) {
		super(cantidadHijos, casado);
		this.aniosAntiguedad = aniosAntiguedad;
	}

	public double sueldoBasico() {
		return 50000;
	}

	public double sueldoAdicional() {
		double sum = this.getCantidadHijos() * 2000 + this.aniosAntiguedad * 2000;
		return this.isCasado()? sum + 5000 : sum;
	}
}