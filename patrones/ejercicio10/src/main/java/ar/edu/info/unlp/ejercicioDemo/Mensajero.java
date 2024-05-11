package ar.edu.info.unlp.ejercicioDemo;

public class Mensajero {
	private Conexion conexion;
	
	public Mensajero(Conexion conexion) {
		this.conexion=conexion;
	}
	
	public String enviar(String mensaje) {
		return this.conexion.enviar(mensaje);
	}
	
}
