package ar.edu.info.unlp.ejercicioDemo;

public class Provisorio extends ExcursionState{

	public Provisorio(Excursion e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void addParticipant(Usuario user) {
		this.getExcursion().getParticipants().add(user);
        if (this.getExcursion().getParticipants().size() >= this.getExcursion().getMinimumQuota()) {
        	this.getExcursion().setState(new EnProgreso(this.getExcursion()));
        }
    }
	@Override
	public String getInfo() {
        int needed = this.getExcursion().getMinimumQuota() - this.getExcursion().getParticipants().size();
        return String.format("Name: %s, Cost: %.2f, Dates: %s to %s, Meeting Point: %s, Needed to start: %d",
        		this.getExcursion().getName(),
        		this.getExcursion().getCost(), 
        		this.getExcursion().getStartDate(), 
        		this.getExcursion().getEndDate(), 
        		this.getExcursion().getMeetingPoint(), needed);
    }

}
