package ar.edu.info.unlp.ejercicioDemo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class ToDoItem {
    private String name;
    private List<String> comments = new ArrayList<>();
    private ToDoItemState state;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public ToDoItem(String name) {
        this.name = name;
        this.state = new Pending(this);
    }

    public void start() {
        this.state.start();
        this.setStartTime(LocalDateTime.now());
    }

    public void togglePause() {
        this.state.togglePause();
    }

    public void finish() {
        this.state.finish();
        this.setEndTime(LocalDateTime.now());
    }

    public Duration workedTime() {
        return this.state.workedTime();
    }

    public void addComment(String comment) {
        this.state.addComment(comment);
    }

    // Getters y setters
    public List<String> getComments() {
        return comments;
    }

    public void setState(ToDoItemState newState) {
        this.state = newState;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime; 
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
    
    public ToDoItemState getState() {
    	return this.state;
    }
}

