package cards;

public class SilverCard extends Card {
    private static final double INITIAL_DISCOUNT_RATE = 2;

    public SilverCard(double turnover) {
        super(turnover, INITIAL_DISCOUNT_RATE);
    }
}
