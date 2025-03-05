import java.util.*;


public class Barber {

	public Barber(BarberShop q) {
		shop = q;
		random = new Random();
	}

	public void serveCustomer(){
		int i;
		for(i=0;i<120;i++){
			shop.serveCustomer();
			try{
				Thread.sleep(random.nextInt(300));
			} catch (InterruptedException e){System.out.println(e.getMessage());}
		}
	}

	private BarberShop shop;
	private Random random;
}
