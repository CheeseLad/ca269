import java.io.*;
import java.util.*;
/**
 * Class Item
 * Represents Food Items
 * has name, weight, price
 */
class Item {
    private final String name;
    private final double price;

    /**
     * Creates an Item
     * @param name of item
     * @param price of item
     */
    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }

    public String toString() {
        return this.name + " " + this.price;
    }
}

class Basket {
    private final Stack<Item> basket;

    Basket() {
        // TODO - create new stack for basket
        basket = new Stack<Item>();
    }

    public void addItem(Item item) {
        basket.add(item);
    }

    public Item removeItem() {
        if (basket.empty()) {
            return null;
        } else {
            return basket.pop();
        }
    }

    public String toString() {
        return "basket:" + this.basket.toString();
    }

    public int getSize() {
        return basket.size();
    }
}

class Checkout {
    private final Queue<Item> checkout;

    Checkout(Basket basket) {
        // TODO - create the queue, add items from basket by using addItem()
        // first, create a new queue for the checkout
        // remember - Queue is an interface, so you need to choose a suitable
        // implementation like LinkedList
        // second, go through the basket, remove each item out of the basket
        // and add it to the checkout
        checkout = new LinkedList<Item>();
        for (int i = 0; i < basket.getSize() * 6; i++) {
            addItem(basket.removeItem());
        }
    }

    public void addItem(Item item) {
        // TODO - add item to the checkout queue
        checkout.add(item);
    }

    public Item removeItem() {
        // TODO - remove item from the checkout queue
        // don't forget to check if its empty first!
        if (checkout.isEmpty()) {
            return null;
        } else {
            return checkout.remove();
        }
    }

    public String toString() {
        return "checkout:" + this.checkout.toString();
    }

    public int getSize() {
        return checkout.size();
    }
    
}

class Bill {
    private final Map<String,Integer> basket;
    private double price;

    Bill(Checkout checkout) {
        basket = new LinkedHashMap<String,Integer>();
        for (int i = 0; i < checkout.getSize() * 6; i++) {
            billItem(checkout.removeItem());
        }
        // TODO - initialise Map, set price, bill items from checkout
        // first, create the Map for the basket - just like Queue,
        // you must select an implementation such as LinkedHashMap
        // second, our starting price is zero - there are no items yet
        // third, iterate through the checkout items -
        // take an item out of the checkout, and bill it
        }

    public void billItem(Item item) {
        String tmp = item.getName().toString();
        if (!basket.containsKey(tmp)) {
            basket.put(tmp, 1);
            price = price + item.getPrice();
        } else {
            int value = basket.get(tmp);
            basket.put(tmp, value + 1);
            price = price + item.getPrice();
        }
        // TODO - put item in map, keep count of same items being billed
        // Note that the Map is from key String to value Integer
        // Items have names as Strings and count of items is an integer
        // first, check if the Item already exists in the Map -
        // the Item name is what we use as the key
        // If it exists - we need to increment its counter by 1
        // If not - we need to create a new key with the item name and value 1
        // second, add the item's price to the bill total price
    }

    public double getTotal() {
        return this.price;
    }

    public String toString() {
        String output = "";
        for(String item: this.basket.keySet()) {
            output += item + " (" + this.basket.get(item) + "nos)\n";
        }
        return output + "total: " + this.price;
    }
}

public class ShopInventory2 {

public static void main(String[] args) {
    Basket basket = new Basket();
    loadBasket(basket);
    // System.out.println(basket); // for DEBUG
    Checkout checkout = new Checkout(basket);
    // System.out.println(checkout); // for DEBUG
    Bill bill = new Bill(checkout);
    System.out.println(bill);
}

static void loadBasket(Basket basket) {
    basket.addItem(new Item("Twinings Earl Grey Tea", 4.50));
    basket.addItem(new Item("Folans Orange Marmalade", 4.00));
    basket.addItem(new Item("Free-range Eggs", 3.35));
    basket.addItem(new Item("Brennan's Bread", 2.15));
    basket.addItem(new Item("Ferrero Rocher", 7.00));
    basket.addItem(new Item("Ferrero Rocher", 7.00));
}
}