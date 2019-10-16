package cards;

public class Card {

    private double turnover;
    private double discountRate;

    Card(double turnover, double discountRate) {
        this.turnover = turnover;
        this.discountRate = discountRate;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
