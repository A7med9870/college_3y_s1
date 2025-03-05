public class Main {

    public static void main(String[] args) {
        // 2 shops around the main
        FishmongerShop shop1 = new FishmongerShop();
        FishmongerShop shop2 = new FishmongerShop();

        // have fishmongers, each assigned to a primary shop
        Fishmonger fishmonger1 = new Fishmonger(shop1, shop2);
        Fishmonger fishmonger2 = new Fishmonger(shop2, shop1);

        // to get cusomters to order at them
        Customer customer1 = new Customer(shop1, shop2);
        Customer customer2 = new Customer(shop1, shop2);
        Customer customer3 = new Customer(shop1, shop2);

        // Start fishmongers and customers
        fishmonger1.start();
        fishmonger2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        // try {
        //     // Wait for customers to finish
        //     customer1.join();
        //     customer2.join();
        //     customer3.join();

        //     // Stop fishmongers
        //     fishmonger1.interrupt();
        //     fishmonger2.interrupt();
        // } catch (InterruptedException e) {
        //     System.out.println(e.getMessage());
        // }
    }
}
