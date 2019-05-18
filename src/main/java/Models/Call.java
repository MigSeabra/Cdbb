package Models;

import java.time.LocalTime;

public class Call {

    private LocalTime callStartTime;
    private LocalTime callEndTime;
    private Integer callNumber;
    private Integer calledNumber;

    public Call() {}

    public Call(LocalTime callStartTime, LocalTime callEndTime, Integer callNumber, Integer calledNumber) {
        this.callStartTime = callStartTime;
        this.callEndTime = callEndTime;
        this.callNumber = callNumber;
        this.calledNumber = calledNumber;
    }

    public LocalTime getCallStartTime() {
        return callStartTime;
    }

    public void setCallStartTime(LocalTime callStartTime) {
        this.callStartTime = callStartTime;
    }

    public LocalTime getCallEndTime() {
        return callEndTime;
    }

    public void setCallEndTime(LocalTime callEndTime) {
        this.callEndTime = callEndTime;
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
}
