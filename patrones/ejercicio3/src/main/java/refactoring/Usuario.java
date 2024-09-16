package refactoring;

public class Usuario {
    String tipoSubscripcion;
    Subscripcion subs;
    // ...
    public void setTipoSubscripcion(Subscripcion subs, String unTipo) {
        this.subs=subs;
    	this.tipoSubscripcion = unTipo;
    }
    public double calcularCostoPelicula(Pelicula pelicula) {
        return subs.calcularCostoPelicula(pelicula, tipoSubscripcion);
    }
}