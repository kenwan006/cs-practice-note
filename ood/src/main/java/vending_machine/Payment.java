package vending_machine;

import java.sql.SQLOutput;

public class Payment {
    private Item item;
    private double insertedAmount;

    public Payment(Item item, double insertedAmount) {
        this.item = item;
        this.insertedAmount = insertedAmount;
    }

    public boolean checkout() {
        if (item.getPrice() > insertedAmount) {
            System.out.println("Payment failed. You the amount is not enough!");
            return false;
        } else {
            System.out.println("You inserted $" + insertedAmount + " to buy a " + item.getName());
            insertedAmount -= item.getPrice();
            System.out.println("Payment successful, and here is the change: " + insertedAmount);
            return true;
        }
    }

}
