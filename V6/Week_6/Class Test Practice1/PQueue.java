import java.util.ArrayList;

public class PQueue {

	public PQueue() {
		w = new ArrayList<Object>();
	}

	public void enter(Object item) {
		System.out.println("New Job. Queue had " + w.size() + " jobs pending. ");
		w.add(item);
	}

	public Object serveJob(){
		Object item = null;
		if(w.size()==0) System.out.println("No jobs in the queue");
		else {
			System.out.println("Printer serving. Queue had " + w.size() + " jobs pending. ");
			item = w.get(0);
			w.remove(0);
		}
		return item;
	}

	private ArrayList<Object> w;

}
