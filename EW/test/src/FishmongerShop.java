import java.util.ArrayList;

public class FishmongerShop {
    private ArrayList<Object> customers_in; // Customers inside the shop
    private ArrayList<Object> customers_waiting; // Customers waiting outside the shop
    private final int MAX_CAPACITY = 4;

    public FishmongerShop() {
        customers_in = new ArrayList<Object>();
        customers_waiting = new ArrayList<Object>();
    }

    public synchronized void enter(Object item) {
        // If the shop is full, add the customer to the waiting queue
        if (customers_in.size() >= MAX_CAPACITY) {
            System.out.println("Shop is full. Customer waits outside.");
            customers_waiting.add(item);
            while (customers_in.size() >= MAX_CAPACITY) {
                try {
                    wait(); // Wait until a spot becomes available
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // Add the customer to the shop
        System.out.println("New Customer. Shop had " + customers_in.size() + " customers waiting.");
        customers_in.add(item);
        notifyAll(); // Notify the fishmonger and waiting customers
    }

    public synchronized Object serveCustomer() {
        // If the shop is empty, the fishmonger sleeps
        while (customers_in.isEmpty()) {
            try {
                System.out.println("Shop is empty. Fishmonger is now resting.");
                wait(); // Fishmonger waits for a customer to arrive
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        // Serve the customer
        System.out.println("Fishmonger currently serving. Shop had " + customers_in.size() + " customers waiting.");
        Object item = customers_in.get(0);
        customers_in.remove(0);

        // If there are customers waiting outside, let one in
        if (!customers_waiting.isEmpty()) {
            Object nextCustomer = customers_waiting.get(0);
            customers_waiting.remove(0);
            customers_in.add(nextCustomer);
            System.out.println("Customer from waiting queue enters the shop.");
            notifyAll(); // Notify waiting customers
        }

        return item;
    }

    // method to check if the shop is empty
    public synchronized boolean isEmpty() {
        return customers_in.isEmpty();
    }

    // method to check if the shop is full
    public synchronized boolean isFull() {
        return customers_in.size() >= MAX_CAPACITY;
    }
}