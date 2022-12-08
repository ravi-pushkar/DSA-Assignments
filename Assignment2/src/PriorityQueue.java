
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
	
    //TODO Complete the Priority Queue implementation
    // You may create other member variables/ methods if required.
    public PriorityQueue(int capacity) {    
    	this.capacity=capacity;
    	this.queue=new Node[this.capacity];
    }

    public int size() {
    	return this.currentSize;
    
    }

    public boolean isEmpty() {
    	return this.currentSize==0;

    }
	
    public boolean isFull() {
    	return this.currentSize==this.capacity;

    }

    public void enqueue(Node<V> node) {
    	if(this.isFull())
    	{
    		System.out.println("Queue is full");
    		return ;
    	}
    		this.queue[currentSize]=node;
    		currentSize++;
    	 
    }
    public void add(int priority,V value)
    {
    	Node<V> node=new Node<V>(priority,value);
    	this.enqueue(node);
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
    	if(this.isEmpty()) {
    		System.out.println("Queue is Empty");
    		return null;
    	}
    		int maxprio=0;
    		for(int i=0;i<(this.currentSize);i++)
        	{
    		   if(this.queue[maxprio].getPriority()>this.queue[i].getPriority())
    		   {
    			   maxprio=i;
    		   }
        	}
    		NodeBase<V> res=this.queue[maxprio];
    		for(int i=maxprio+1;i<this.currentSize;i++)
    		{
    			this.queue[i-1]=this.queue[i];
    		}
    		this.queue[currentSize-1]=null;
    		this.currentSize-=1;
    		return res;
        	
    	 
    	

    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i+1].show();
	}
    }
   
}

