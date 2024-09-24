package vending_machine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Item, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(Item item, Integer quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
        System.out.println("" + quantity + " " + item.getName() + " has been refilled.");
    }

    public void consumeItem(Item item) {
        items.put(item, items.get(item) - 1);
        System.out.println("Thanks for buying the " + item.getName());
        if (items.get(item) < 10) {
            System.out.println("This item is in low stock, please refill!");
        }
    }

    public void display() {
        for (Item item : items.keySet()) {
            System.out.println("Current stock for the item " + item.getName() + " is: " + items.get(item));
        }
    }

    public boolean checkAvailable(Item item) {
        if (items.get(item) > 0) {
            return true;
        } else {
            System.out.println("This item is out of stock.");
            return false;
        }

    }
}
