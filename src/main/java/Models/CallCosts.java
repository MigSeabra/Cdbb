package Models;

public enum CallCosts {
    FIVE_MINUTES(0.05),
    REMAINING_MINUTES(0.02);

    private Double costCent;

    CallCosts(Double costCent){
        this.costCent = costCent;
    }

    Double getValue() {
        return this.costCent;
    }
}
