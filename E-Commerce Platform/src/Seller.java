import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        //TODO Complete the constructor method by initializing the attibutes
    	this.catalog=catalog;
    	this.setSleepTime(sleepTime);
    	this.lock=lock;
    	this.full=full;
    	this.empty=empty;
    	this.inventory=inventory;
        // ...
    }
    
    public void sell() throws InterruptedException {
	try {
		lock.lock();
		while(catalog.isFull())
		{
			full.await();
			
		}
		if(!inventory.isEmpty()) {
			Node itm =(Node) inventory.dequeue();
			catalog.enqueue(itm);
			empty.signal();
		}
            //TODO Complete the try block for produce method
            // ...
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
            //TODO Complete this block
		
		lock.unlock();
	}		
    }
}
