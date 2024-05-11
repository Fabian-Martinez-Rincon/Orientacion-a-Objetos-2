package ar.edu.info.unlp.ejercicioDemo;

import java.util.stream.Collectors;

public class EnProgreso extends ExcursionState{

	public EnProgreso(Excursion e) {
		super(e);
	}

	@Override
	public void addParticipant(Usuario user) {
		this.getExcursion().getParticipants().add(user);
        if (this.getExcursion().getParticipants().size() >= this.getExcursion().getMaximumQuota()) {
        	this.getExcursion().setState(new Definitiva(this.getExcursion()));
        }
    }

	@Override
	public String getInfo() {
        int slotsRemaining = this.getExcursion().getMaximumQuota() - this.getExcursion().getParticipants().size();
        String emails = this.getExcursion().getParticipants().stream()
                                .map(Usuario::getEmail)
                                .collect(Collectors.joining(", "));
        return String.format("Name: %s, Cost: %.2f, Dates: %s to %s, Meeting Point: %s, Emails: %s, Slots remaining: %d",
        		this.getExcursion().getName(), 
        		this.getExcursion().getCost(), 
        		this.getExcursion().getStartDate(), 
        		this.getExcursion().getEndDate(), 
        		this.getExcursion().getMeetingPoint(), emails, slotsRemaining);
    }

}
