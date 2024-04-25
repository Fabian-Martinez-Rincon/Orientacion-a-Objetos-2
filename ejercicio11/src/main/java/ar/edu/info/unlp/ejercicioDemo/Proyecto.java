package ar.edu.info.unlp.ejercicioDemo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class Proyecto {
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String objetivo;
    private double margenGanancia;
    private int numIntegrantes;
    private double costoPorDia;
    private Etapa estado;

    public Proyecto(String nombre, LocalDate fechaInicio, LocalDate fechaFin, 
                    String objetivo, 
                    int numIntegrantes, double costoPorDia) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.objetivo = objetivo;
        this.margenGanancia = 0.07;
        this.numIntegrantes = numIntegrantes;
        this.costoPorDia = costoPorDia;
        this.estado = new Construccion(this); 
    }

    public void setEtapa(Etapa estado) {
    	this.estado = estado;
    }
    
    public void aprobarEtapa() {
    	this.estado.aprobarEtapa();
    }
    
    public double costoProyecto() {
    	long dias = ChronoUnit.DAYS.between(this.fechaInicio, this.fechaFin);
        return dias * this.numIntegrantes * this.costoPorDia;
    }
    
    public double calcularPrecio() {        
        return this.costoProyecto() + (this.costoProyecto() * this.margenGanancia);
    }
    
    public void modificarMargenDeGanancias(double margen) {
		if (this.estado.esModificableMargen(margen)) {
			this.margenGanancia = margen;
		}
	}
    
    public void cancelarProyecto() {
        if (this.estado instanceof Cancelada) {
            System.out.println("El proyecto ya está cancelado.");
        } else if (this.estado instanceof Confirmada || this.estado instanceof EnEvaluacion) {
            throw new IllegalStateException("El proyecto no puede ser cancelado en su estado actual.");
        } else {
            this.setEtapa(new Cancelada(this));
            
            if (!this.objetivo.contains("(Cancelado)")) {
                this.objetivo += " (Cancelado)";
            }
            
        }
    }

	public Etapa getEstado() {
		return this.estado;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public LocalDate getFechaInicio() {
		// TODO Auto-generated method stub
		return this.fechaInicio;
	}
	public LocalDate getFechaFin() {
		// TODO Auto-generated method stub
		return this.fechaFin;
	}

	public double getCostoPorDia() {
		// TODO Auto-generated method stub
		return this.costoPorDia;
	}
	public String getObjetivo() {
		return this.objetivo;
	}

	public int getNumIntegrantes() {
		// TODO Auto-generated method stub
		return this.numIntegrantes;
	}
	
	public double getMargenGanancia () {
		return this.margenGanancia;
	}
	
}
