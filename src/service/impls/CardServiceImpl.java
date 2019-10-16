package service.impls;

import cards.Card;
import cards.BronzeCard;
import cards.GoldCard;
import cards.SilverCard;
import service.CardService;

public class CardServiceImpl implements CardService {

    public CardServiceImpl() {

    }

    @Override
    public Card createCard(String type, double turnover) {
        Card card = null;
        double rate = 0;

        switch (type.toLowerCase().trim()){
            case "bronze":
                card = new BronzeCard(turnover);
                if (turnover > 100 && turnover < 300){
                    rate = 1;
                }else if (turnover > 300){
                    rate = 2.5;
                }
                break;

            case "silver":
                card = new SilverCard(turnover);
                if (turnover > 300){
                    rate = 3.5;
                }
                break;

            case "gold":
                card = new GoldCard(turnover);

                int additionalRate = (int) Math.floor(turnover / 100);
                if (additionalRate > 8){
                    additionalRate = 8;
                }

                rate = card.getDiscountRate() + additionalRate;
                break;
        }
        if (rate != 0){
            card.setDiscountRate(rate);
        }

        return card;
    }
}
