package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	List<Empleado> empleados = new ArrayList<Empleado>();
	
	public void agregarEmpleado(Empleado e) {
		this.empleados.add(e);
	}
}
