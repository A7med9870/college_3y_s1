import java.util.Date;
import java.util.Random;

public class Customer extends Thread {

    private FishmongerShop shop1;
    private FishmongerShop shop2;
    private Random random;

    public Customer(FishmongerShop shop1, FishmongerShop shop2) {
        this.shop1 = shop1;
        this.shop2 = shop2;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 120; i > 0; i--) {
            Date time = new Date();
            FishmongerShop chosenShop = random.nextBoolean() ? shop1 : shop2; // Randomly choose a shop
            synchronized (chosenShop) {
                if (chosenShop.isFull()) {
                    // If the chosen shop is full, try the other shop
                    FishmongerShop otherShop = (chosenShop == shop1)
                        ? shop2
                        : shop1;
                    System.out.println(
                        "Shop " +
                        (chosenShop == shop1 ? "1" : "2") +
                        " is full. Waiting for the other shop."
                    );
                    otherShop.enter(time);
                } else {
                    chosenShop.enter(time);
                }
            }
            try {
                Thread.sleep(random.nextInt(400)); // Simulate time between customer arrivals
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
