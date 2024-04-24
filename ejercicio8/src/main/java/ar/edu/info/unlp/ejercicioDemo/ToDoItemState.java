package ar.edu.info.unlp.ejercicioDemo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class ToDoItemState {
    protected ToDoItem item;

    public ToDoItemState(ToDoItem item) {
        this.item = item;
    }

    public abstract void start();
    public abstract void togglePause();
    public abstract void finish();
    public abstract Duration workedTime();

    public void addComment(String comment) {
        if (!(this instanceof Finished)) {
            this.item.getComments().add(comment);
        }
    }
}
