package state;

public abstract class Estado {
    protected Excursion excursion;

    public Estado(Excursion excursion) {
        this.excursion = excursion;
    }

    public abstract void inscribir(Usuario unUsuario);
    public abstract String obtenerInformacion();
}
