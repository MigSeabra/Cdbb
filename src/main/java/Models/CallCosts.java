package Models;

/**
 * Costs enum
 * Stores call minutes and respective cost
 */
public enum CallCosts {
    FIVE_MINUTES(5, 0.05),
    REMAINING_MINUTES(null, 0.02);

    private Integer minutes;
    private Double cost;

    CallCosts(Integer minutes, Double cost){
        this.minutes = minutes;
        this.cost = cost;
    }

    Integer getMinutes() {
        return this.minutes;
    }

    Double getCost() {
        return this.cost;
    }
}