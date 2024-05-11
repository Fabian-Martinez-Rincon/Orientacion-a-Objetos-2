package ar.edu.info.unlp.ejercicioDemo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Paused extends ToDoItemState{

	public Paused(ToDoItem item) {
		super(item);
	}

	@Override
	public void start() { //Consultar
		item.setState(new InProgress(item));
	}

	@Override
	public void togglePause() {
		item.setState(new InProgress(item));
	}

	@Override
	public void finish() {
		item.setState(new Finished(item));
        item.setEndTime(LocalDateTime.now());
		
	}

	@Override
    public Duration workedTime() {
        LocalDateTime end = item.getEndTime() != null ? item.getEndTime() : LocalDateTime.now();
        return Duration.between(item.getStartTime(), end);
    }


}
