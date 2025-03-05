import java.util.Random;

public class Fishmonger extends Thread {
    private FishmongerShop primaryShop; // The fishmonger's primary shop
    private FishmongerShop secondaryShop; // The neighboring shop
    private Random random;

    public Fishmonger(FishmongerShop primaryShop, FishmongerShop secondaryShop) {
        this.primaryShop = primaryShop;
        this.secondaryShop = secondaryShop;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            // Serve customers in the primary shop
            synchronized (primaryShop) {
                if (!primaryShop.isEmpty()) {
                    primaryShop.serveCustomer();
                }
            }

            // Serve customers in the secondary shop
            synchronized (secondaryShop) {
                if (!secondaryShop.isEmpty()) {
                    System.out.println("Fishmonger from primary shop helping in the secondary shop.");
                    secondaryShop.serveCustomer();
                }
            }

            // If both shops are empty, rest
            synchronized (primaryShop) {
                synchronized (secondaryShop) {
                    if (primaryShop.isEmpty() && secondaryShop.isEmpty()) {
                        System.out.println("Both shops are empty. Fishmonger is resting.");
                        try {
                            primaryShop.wait(); // Wait for a customer to arrive
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }

            try {
                Thread.sleep(random.nextInt(300)); // Simulate time between serving customers
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}