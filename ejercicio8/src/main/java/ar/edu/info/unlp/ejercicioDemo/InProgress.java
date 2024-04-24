package ar.edu.info.unlp.ejercicioDemo;

import java.time.Duration;
import java.time.LocalDateTime;

public class InProgress extends ToDoItemState{

	public InProgress(ToDoItem item) {
		super(item);
	}

	@Override
	public void start() {
		// Ya en progreso no hace nada crack
	}

	@Override
	public void togglePause() {
		item.setState(new Paused(item));
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
