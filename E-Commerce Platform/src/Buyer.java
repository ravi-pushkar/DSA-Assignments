import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
    	this.catalog=catalog;
    	this.setSleepTime(sleepTime);
    	this.lock=lock;
    	this.full=full;
    	this.empty=empty;
    	this.setIteration(iteration);
    	
        //TODO Complete the Buyer Constructor method
        // ...
    }
    public void buy() throws InterruptedException {
	try {
		
            //TODO Complete the try block for consume method
            // ...
		lock.lock();
		while(catalog.isEmpty()) 
		{
			empty.await();
		}
		Node n = (Node) catalog.dequeue();
	    System.out.print("Consumed "); // DO NOT REMOVE (For Automated Testing)
            n.show(); // DO NOT REMOVE (For Automated Testing)
            // ...
            full.signal();
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
		lock.unlock();
		
            //TODO Complete this block
	}
    }
}
