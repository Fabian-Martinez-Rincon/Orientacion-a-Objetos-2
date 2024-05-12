package state;

public class EstadoDefinitiva extends Estado {
    public EstadoDefinitiva(Excursion excursion) {
        super(excursion);
    }

    public void inscribir(Usuario unUsuario) {
        if (!this.excursion.alcanzoMaximo()) {
            this.excursion.getInscriptos().add(unUsuario);
        } else {
            this.excursion.setEstado(new EstadoCompleta(this.excursion));
            this.excursion.inscribir(unUsuario); 
        }
    }

    public String obtenerInformacion() {
        return "\nLa excursión está confirmada y tiene espacio para más inscripciones.";
    }
}