package refactoring;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pelicula {
	private double costo;
    LocalDate fechaEstreno;
    // ...
    public Pelicula(double costo) {
    	this.costo=costo;
    	this.fechaEstreno = LocalDate.of(2000, 12, 8);
    }
    public double getCosto() {
        return this.costo;
    }
    
    public double calcularCargoExtraPorEstreno(){
        return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
    }
}