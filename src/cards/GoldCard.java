package cards;

public class GoldCard extends Card {
    private static final double INITIAL_DISCOUNT_RATE = 2;

    public GoldCard(double turnover) {
        super(turnover, INITIAL_DISCOUNT_RATE);
    }
}
