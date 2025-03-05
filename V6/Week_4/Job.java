import java.util.*;

public class Job {

	public Job(PQueue q) {
		pqueue = q;
		random = new Random();
	}

	public void enterQueue(){
		int i;
		for(i=120;i>0;i--){
			
			// Time of i-th jobi's arrival is recoded in the pqueue
			// can be used to compute service times for each customer
			Date time = new Date();
			pqueue.enter(time);
			try{
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e){System.out.println(e.getMessage());}

		}
	}

	private PQueue pqueue;
	private Random random;
}
