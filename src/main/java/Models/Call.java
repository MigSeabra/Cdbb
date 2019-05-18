package Models;

import java.time.LocalTime;

public class Call {

    private LocalTime startTime;
    private LocalTime endTime;
    private Integer callNumber;
    private Integer calledNumber;
    private Long duration;
    private Double cost;

    public Call() {}

    public Call(LocalTime startTime, LocalTime endTime, Integer callNumber, Integer calledNumber, Long duration) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.callNumber = callNumber;
        this.calledNumber = calledNumber;
        this.duration = duration;

        Double minutes = Math.ceil((double)duration/60);

        if (minutes <= CallCosts.FIVE_MINUTES.getMinutes()) {
            this.cost = CallCosts.FIVE_MINUTES.getCost()*minutes;
        } else {
            this.cost = CallCosts.FIVE_MINUTES.getCost()*CallCosts.FIVE_MINUTES.getMinutes()
                    + CallCosts.REMAINING_MINUTES.getCost()*(minutes-CallCosts.FIVE_MINUTES.getMinutes());
        }
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(Integer callNumber) {
        this.callNumber = callNumber;
    }

    public Integer getCalledNumber() {
        return calledNumber;
    }

    public void setCalledNumber(Integer calledNumber) {
        this.calledNumber = calledNumber;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
