package system;

import cards.Card;
import service.CardService;
import service.impls.CardServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppEngine implements Runnable {
    private static final String WELCOME_MESSAGE =
            "Type start to continue or exit to stop the program!";
    private static final String WELCOME_MESSAGE_FOR_TYPE_OF_CARD =
            "Please, enter the type of the card! (Bronze, Silver or Gold)";
    private static final String WELCOME_MESSAGE_FOR_TURNOVER =
            "Please, enter the turnover for the previous month! (A positive number)";
    private static final String WELCOME_MESSAGE_FOR_PURCHASE_VALUE =
            "Please, enter the purchase value! (A positive number)";
    private static final String INVALID_INPUT = "Invalid input!";


    private final BufferedReader reader;
    private final CardService cardService;

    public AppEngine() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));;
        this.cardService = new CardServiceImpl();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(WELCOME_MESSAGE);

            String type = "";
            double turnover = 0;
            double purchaseValue = 0;

            try {
                String command = reader.readLine();
                if (command.toLowerCase().equals("exit")){
                    break;
                }else if(command.toLowerCase().equals("start")){
                    type = this.readType();
                    turnover = this.readTurnover();
                    purchaseValue = this.readPurchaseValue();
                }
            } catch (Exception e) {
                System.out.println(INVALID_INPUT);
                continue;
            }

            Card card = cardService.createCard(type, turnover);

            this.printInput(card, purchaseValue);
        }
    }

    private String readType() throws IOException {
        System.out.println(WELCOME_MESSAGE_FOR_TYPE_OF_CARD);
        String type = reader.readLine();

        if (!isTypeCorrect(type)){
            throw new IllegalArgumentException();
        }
        return type;
    }

    private boolean isTypeCorrect(String type) {
        type = type.toLowerCase().trim();
        return type.equals("bronze") || type.equals("silver") || type.equals("gold");
    }

    private double readTurnover() throws IOException {
        System.out.println(WELCOME_MESSAGE_FOR_TURNOVER);
        double turnover =  Double.parseDouble(reader.readLine());

        if (turnover < 0){
            throw new IllegalArgumentException();
        }
        return turnover;
    }

    private double readPurchaseValue() throws IOException {
        System.out.println(WELCOME_MESSAGE_FOR_PURCHASE_VALUE);
        double value = Double.parseDouble(reader.readLine());

        if (value < 0){
            throw new IllegalArgumentException();
        }
        return value;
    }

    private void printInput(Card card, double purchaseValue) {
        PayDesk.printInfoOfThePurchase(card, purchaseValue);
    }
}
