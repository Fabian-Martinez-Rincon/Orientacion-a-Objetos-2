package ar.edu.info.unlp.ejercicioDemo;

public class ConexionSegura extends Conexion{
	private Encriptador encriptador;
	
	public ConexionSegura(Encriptador e) {
		this.encriptador=e;
	}

	@Override
	public String enviar(String mensaje) {
		return this.encriptador.encriptar(mensaje);
		
	}
	
	public void setEncriptador(Encriptador encriptador) {
        this.encriptador = encriptador;
    }

}
