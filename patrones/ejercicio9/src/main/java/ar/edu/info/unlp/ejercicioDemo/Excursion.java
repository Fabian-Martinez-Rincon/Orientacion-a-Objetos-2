package ar.edu.info.unlp.ejercicioDemo;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String meetingPoint;
    private double cost;
    private int minimumQuota;
    private int maximumQuota;
    private ExcursionState state;
    private List<Usuario> participants = new ArrayList<>();
    private List<Usuario> waitList = new ArrayList<>();

    public Excursion(String name, LocalDateTime startDate, LocalDateTime endDate, String meetingPoint, double cost, int minQuota, int maxQuota) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.meetingPoint = meetingPoint;
        this.cost = cost;
        this.minimumQuota = minQuota;
        this.maximumQuota = maxQuota;
        this.state = new Provisorio(this);  // Estado inicial con referencia a esta excursión
    }

    public void addParticipant(Usuario user) {
        state.addParticipant(user);
        if (participants.size() >= maximumQuota) {
            setState(new Definitiva(this));
        } else if (participants.size() >= minimumQuota) {
            setState(new EnProgreso(this));
        }
    }

    
    public ExcursionState getState() {
    	return this.state;
    }
    public String getInfo() {
        return state.getInfo();
    }

    // Getters
    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getMeetingPoint() {
        return meetingPoint;
    }

    public double getCost() {
        return cost;
    }

    public int getMinimumQuota() {
        return minimumQuota;
    }

    public int getMaximumQuota() {
        return maximumQuota;
    }

    public List<Usuario> getParticipants() {
        return participants;
    }

    public List<Usuario> getWaitList() {
        return waitList;
    }

    // Setters
    public void setState(ExcursionState newState) {
        this.state = newState;
    }
    
    
}
