package cards;

public class BronzeCard extends Card {
    private static final double INITIAL_DISCOUNT_RATE = 0.0;

    public BronzeCard(double turnover) {
        super(turnover, INITIAL_DISCOUNT_RATE);
    }
}
