package ar.edu.info.unlp.ejercicioDemo;

public abstract class ExcursionState {
	private Excursion excursion;
	
	public ExcursionState(Excursion e) {
		this.excursion=e;
	}
	
	public Excursion getExcursion() {
		return this.excursion;
	}
	
	public abstract void addParticipant(Usuario user);
	public abstract  String getInfo();
   
}
