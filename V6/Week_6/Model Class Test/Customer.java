import java.util.*;

public class Customer {

	public Customer(BarberShop q) {
		shop = q;
		random = new Random();
	}

	public void enterShop(){
		int i;
		for(i=120;i>0;i--){
			Date time = new Date();
			shop.enter(time);
			try{
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e){System.out.println(e.getMessage());}

		}
	}

	private BarberShop shop;
	private Random random;
}
