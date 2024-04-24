package ar.edu.info.unlp.ejercicioDemo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Finished extends ToDoItemState{

	public Finished(ToDoItem item) {
		super(item);
		item.setEndTime(LocalDateTime.now());
	}

	@Override
	public void start() {
		throw new IllegalStateException("Cannot start a finished task.");
	}

	@Override
	public void togglePause() {
		throw new IllegalStateException("Cannot pause or resume a finished task.");
	}

	@Override
	public void finish() {
		//si ya termino se supone que no hace nada
	}

	@Override
	public Duration workedTime() {
        return Duration.between(item.getStartTime(), item.getEndTime());
    }

	@Override
    public void addComment(String comment) {
        throw new IllegalStateException("Cannot add comments to a finished task.");
    }
}
