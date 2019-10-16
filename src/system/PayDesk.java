package system;


import cards.Card;

class PayDesk {

    static void printInfoOfThePurchase(Card card, double value){
        double discount = calculateDiscount(card.getDiscountRate(), value);

        printPurchaseValue(value);
        printDiscountRate(card.getDiscountRate());
        printDiscount(discount);
        printTotalSum(value, discount);
    }

    private static double calculateDiscount(double discountRate, double value){
        return value * (discountRate / 100);
    }

    private static void printPurchaseValue(double value){
        System.out.println(String.format("Purchase value: $%.2f", value));
    }

    private static void printDiscountRate(double discountRate){
        System.out.println(String.format("Discount rate: %.1f%%", discountRate));
    }

    private static void printDiscount(double discount){
        System.out.println(String.format("Discount: $%.2f", discount));
    }

    private static void printTotalSum(double value, double discount) {
        System.out.println(String.format("Total: $%.2f", value - discount));
    }
}
