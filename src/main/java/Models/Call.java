package Models;

import java.time.LocalTime;

/**
 * Model representation of a single call
 */
public class Call {

    private LocalTime startTime;
    private LocalTime endTime;
    private Long callNumber;
    private Long calledNumber;
    private Long duration;
    private Double cost;

    public Call() {}

    /**
     * Constructor for Call model
     * This call cost is calculated according to the following rules:
     * - The first 5 minutes of each call are billed at 5 cents per minute
     * - The remainer of the call is billed at 2 cents per minute
     * @param startTime call start time
     * @param endTime call end time
     * @param callNumber call from number
     * @param calledNumber call to number
     * @param duration call duration
     */
    public Call(LocalTime startTime, LocalTime endTime, Long callNumber, Long calledNumber, Long duration) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.callNumber = callNumber;
        this.calledNumber = calledNumber;
        this.duration = duration;

        Double minutes = Math.ceil((double)(duration)/60);

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

    public Long getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(Long callNumber) {
        this.callNumber = callNumber;
    }

    public Long getCalledNumber() {
        return calledNumber;
    }

    public void setCalledNumber(Long calledNumber) {
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