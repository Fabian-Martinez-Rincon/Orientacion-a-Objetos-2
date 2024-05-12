package state;

public class EstadoProvisoria extends Estado {
    public EstadoProvisoria(Excursion excursion) {
        super(excursion);
    }

    public void inscribir(Usuario unUsuario) {
        if (!this.excursion.alcanzoMaximo()) {
            this.excursion.getInscriptos().add(unUsuario);
            if (this.excursion.alcanzoMinimo()) {
                this.excursion.setEstado(new EstadoDefinitiva(this.excursion));
            }
        }
    }

    public String obtenerInformacion() {
        return "\nActualmente faltan " + (this.excursion.getCupoMinimo() - this.excursion.getInscriptos().size())
                + " personas para alcanzar el cupo mínimo.";
    }
}