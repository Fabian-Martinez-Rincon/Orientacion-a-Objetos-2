package refactoring;

public class Pelicula {
	private double costo;
	
	public Pelicula(double costo) {
		this.costo=costo;
	}
	public double getCosto() {
		return this.costo;
	}
	public double calcularCargoExtraPorEstreno(){
		return this.costo * 10;
	}
}
