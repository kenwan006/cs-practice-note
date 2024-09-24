package vending_machine;

public class VendingMachine {
    private Inventory inventory;
    private String name;

    public VendingMachine(Inventory inventory, String name) {
        this.inventory = inventory;
        this.name = name;
    }
    //display all the available items
    public void display() {
        inventory.display();
    }

    //check out an item
    public void checkOut(Item item, double amount) {
        if (!inventory.checkAvailable(item)) return;
        Payment payment = new Payment(item, amount);
        //if payment is successful, we need to update the inventory
        if (payment.checkout()) {
            inventory.consumeItem(item);
        };
    }

    //refill items to the vending machine
    public void refill(Item item, Integer quantity) {
        inventory.addItem(item, quantity);
    }
}
