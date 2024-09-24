package vending_machine;

public class VendingDemo {

    public static void main(String[] args) {
        Item coke = new Item("coke", 1.25);
        Item water = new Item("coke", 1.50);
        Item tea = new Item("coke", 1.75);

        Inventory inventory = new Inventory();
        inventory.addItem(coke, 30);
        inventory.addItem(water, 50);
        inventory.addItem(tea, 10);

        VendingMachine vendingMachine = new VendingMachine(inventory, "usc village vending machine-1");

        vendingMachine.display();

        vendingMachine.checkOut(coke, 1.00); //not enough money to buy
        vendingMachine.checkOut(coke, 1.50); //valid purchase
        vendingMachine.checkOut(water, 2.00);
        vendingMachine.checkOut(tea, 2.00);


        vendingMachine.refill(coke, 5);

        vendingMachine.display();

    }
}
