package state;

public class EstadoCompleta extends Estado {
    public EstadoCompleta(Excursion excursion) {
        super(excursion);
    }

    public void inscribir(Usuario unUsuario) {
        this.excursion.getEnEspera().add(unUsuario);
    }

    public String obtenerInformacion() {
        return "\nLa excursión está completa. Todos los nuevos inscriptos serán puestos en lista de espera.";
    }
}