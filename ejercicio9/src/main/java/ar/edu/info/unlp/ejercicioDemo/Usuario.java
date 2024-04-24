package ar.edu.info.unlp.ejercicioDemo;

public class Usuario {
	private String nombre;
	private String apellido;
	private String email;
	
	public Usuario(String nombre, String apellido, String email) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.email=email;
	}
	
	public String getNombre() { return this.nombre;}
	public String getApellido() {return this.apellido;}
	public String getEmail() { return this.email;}
	
}
