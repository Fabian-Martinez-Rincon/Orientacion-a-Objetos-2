package ar.edu.info.unlp.ejercicioDemo;

public class Definitiva extends ExcursionState{

	public Definitiva(Excursion e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addParticipant(Usuario user) {
        this.getExcursion().getWaitList().add(user);
    }

	@Override
	public String getInfo() {
        return String.format("Name: %s, Cost: %.2f, Dates: %s to %s, Meeting Point: %s - FULL",
        		this.getExcursion().getName(), 
        		this.getExcursion().getCost(), 
        		this.getExcursion().getStartDate(), 
        		this.getExcursion().getEndDate(), 
        		this.getExcursion().getMeetingPoint());
    }


}
