package service;

import cards.Card;

public interface CardService {
    Card createCard(String type, double turnover);
}
