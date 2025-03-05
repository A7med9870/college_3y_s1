
import java.util.*;


public class Printer {

	public Printer(PQueue q) {
		pqueue = q;
		random = new Random();
	}

	public void serveCustomer(){
		int i;
		for(i=0;i<120;i++){
			pqueue.serveCustomer();
			try{
				Thread.sleep(random.nextInt(300));
			} catch (InterruptedException e){System.out.println(e.getMessage());}
		}
	}

	private PQueue pqueue;
	private Random random;
}
