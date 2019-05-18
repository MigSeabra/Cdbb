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

        this.cost = minutes <= 5 ? CallCosts.FIVE_MINUTES.getValue()*minutes :
                CallCosts.FIVE_MINUTES.getValue()*5 + CallCosts.REMAINING_MINUTES.getValue()*(minutes-5);
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
}
