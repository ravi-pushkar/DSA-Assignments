// This class implements the Queue
public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;
	
    public Queue(int capacity) {  
    	this.capacity = capacity;
    	this.queue=new Node[capacity];
    }

    public int size() {
    	return  this.capacity;
    
    }

    public boolean isEmpty() {
    	return currentSize==0;
    
    }
	
    public boolean isFull() {
    	return this.capacity==currentSize;
    
    }

    public void enqueue(Node<V> node) {
    	if(this.isFull()) {
    		System.out.println("Queue is full");
    		return ;
    	}
    		this.queue[rear]=node;
    		rear=(rear+1)%capacity;
    		currentSize++;
    	 

    
    }

    public NodeBase<V> dequeue() {
    	if(this.isEmpty()) {
    		System.out.println("Queue is empty");
    		return null;
    	}
    		NodeBase<V> t = this.queue[front];
    	   front = (front+1)%capacity;
    	   currentSize--;
    	   return t;
    		
    	 

 

}
}
