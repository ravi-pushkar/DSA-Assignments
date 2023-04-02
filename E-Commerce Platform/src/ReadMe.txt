                                                                        ASSIGNMENT-2
                                                                        ============

>> Node class
Firstly, in the node file, I assigned  the parameters parameters and value associated with it and described the methods to return the priority and value of the node.

>> Queue class
The class Queue<V> implements QueueInterface<V> and I made an array(queue) of type NodeBase<V> and defined the following integer parameters to it: capacity, currentSize, front, rear.
I defined the method size to get the size of the array and this would be equal to the capacity.
Also, I defined methods for checking whether the queue is empty or full. If the currentSize of the queue equals the capacity(size) of the queue the it's completely full.
Moreover,if the currentSize of the queue equals 0 then it is empty.

(a)For the enqueue part:
Firstly, I checked whether the queue is full. If it is full, I simply printed out that the queue is full.Else if it is not full, I added the node to the rear of it and changed the rear to 
[(rear+1) modulo capacity] in order to add the nodes in a cyclic basis.(i.e. after the adding element to the capacity-1 index,the next node get added to 0th index.)Then, I increased the currentSize
 by 1 as 1 additional element has been added to it.

(b)For the dequeue part:
Firstly, I checked whether the queue is empty. If it is empty, I simply printed out that the queue is empty.Else if it is not empty,i removed the node present at front and for this,I changed my front
to [(front+1) modulo capacity] for the same reason stated in enqueue part.Also, I decreased the currentSize by 1 and returned the node earlier present at front.

>> PriorityQueue class
The class PriorityQueue<V> implements QueueInterface<V> and has all the parameters same as in Queue class.Also, the method to get the size and to check whether the queue is full or empty is also the same as 
done in Queue class.

(a)For the enqueue part:
This is done exactly in the same way as done in the Queue class.
Also, I defined a function "add"(which I used in PriorityQueueTestDriver), which enqueue a node with two parameters(one is it's priority and the other is it's value) to the queue array.

(b)For the dequeue part:
Firstly, I checked whether the queue is empty. If it is empty, I simply printed out that the queue is empty.Else if it is not empty,I find out the node with maximum priority and then removed this node and 
shift all other nodes following it by 1(so that their index get reduced by 1) and set the node at currentSize to null. For finding the maximum priority, I initially made the maxprio variable and assigned 0 
to it.And then I iterated over the array queue and whenever the priority at maxprio index was greater than that of the node being iterated through, I changed the maxprio to the index of that node.

>> Buyer And Seller class
Firstly,I completed the constructor of buyer and seller class and defined the various parameter in them i.e. sleepTime,catalogSize,lock,full & empty condition,catalog.iteration(only in case of buyer),inventory
(only in case of seller).
 These methods  are implemented using locks instead of synchronizationblocks to allow synchronized removal of elements from the catalog. These methods ensure that only a single thread is working (Reading or writing) on the shared object. Also the conditionals empty and full are used to wait and notify the threads about the catalog being empty or full.

>> A little naive discussion over how locks ensure synchronization:-
Consider a case in which over catalog is empty and we have 4 threads 2 buyer and 2 seller threads all racing to get access to catalog. Let us name these threads as B_1,B_2 S_1 and S_2. Now let us visualize the case
in which B_1 gets the access. So it locks the lock and all other threads which want to lock the same lock are freezed till the lock unlocks. Immediately the Buyer thread B_1 realizes the catalog is empty so it calls upon the method empty.await() which unlocks the lock
and sets B_1 to sleep. Now the three threads B_2,S_1 and S_2 will race for attaining the lock. If B_2 attains the same above process will be repeated resulting in B_2 being asleep. So let us assume that S_1 gets the access. S_1 on getting access will add element in catalog from the
inventory . It will then notify all other threads which were put to sleep by empty.await() method and the thread(B_1) gets active. In this way locks allow synchronization.



>> Assignment2Driver class
Almost everything was already done in this class. The only two things I did are as follows:
(a) First and foremost,I added all elements of the ArrayList named "list" to inventory queue.
(b) Then,I created multiple buyers(equal to numBuyers) and multiple sellers(equal to numSellers), with their suitable parameters and started them.  
