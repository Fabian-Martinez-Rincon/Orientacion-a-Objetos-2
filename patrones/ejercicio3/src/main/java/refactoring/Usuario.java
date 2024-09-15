package refactoring;

public class Usuario {
	String tipoSubscripcion;
	
	
	public void setTipoSubscripcion(String unTipo) {
		this.tipoSubscripcion = unTipo;
	}
	
	public double calcularCostoPelicula(Pelicula pelicula) {
		double costo = 0;
		if(tipoSubscripcion.equals("Basico")) {
			costo = pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno(); 
		}
		if(tipoSubscripcion.equals("Premium")) {
			costo = pelicula.getCosto() - pelicula.calcularCargoExtraPorEstreno(); 
		}
		return costo;
	}
}
