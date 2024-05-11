package ar.edu.info.unlp.ejercicioDemo;

import java.time.Duration;
import java.time.LocalDateTime;

class Pending extends ToDoItemState {
    public Pending(ToDoItem item) {
        super(item);
    }

    @Override
    public void start() {
        item.setState(new InProgress(item));
        item.setStartTime(LocalDateTime.now());
    }

    @Override
    public void togglePause() {
        throw new IllegalStateException("Cannot pause when in pending state.");
    }

    @Override
    public void finish() {
        // No hace nada si está pendiente.
    }

    @Override
    public Duration workedTime() {
        throw new IllegalStateException("Task has not started yet.");
    }
}
