## Tech Talk 1 : Linked Lists

Linked lists: A way of keeping and managing a list of objects
- Generic data
- ForEach loop support

Generic T
- Operates on objects of any type

### Queue Linked List 
First in, first out
- Head: Start of the list (Ex. Seven)
- Tail: end of the list (Ex. Southward)
- Enqueue and Dequeue

```
Enqueued data: seven
Words count: 1, data: seven 
Enqueued data: slimy
Words count: 2, data: seven slimy 
Enqueued data: snakes
Words count: 3, data: seven slimy snakes 
Enqueued data: sallying
Words count: 4, data: seven slimy snakes sallying 
Enqueued data: slowly
Words count: 5, data: seven slimy snakes sallying slowly 
Enqueued data: slithered
Words count: 6, data: seven slimy snakes sallying slowly slithered 
Enqueued data: southward
Words count: 7, data: seven slimy snakes sallying slowly slithered southward 
Dequeued data: seven
Words count: 6, data: slimy snakes sallying slowly slithered southward 
Dequeued data: slimy
Words count: 5, data: snakes sallying slowly slithered southward 
Dequeued data: snakes
Words count: 4, data: sallying slowly slithered southward 
Dequeued data: sallying
Words count: 3, data: slowly slithered southward 
Dequeued data: slowly
Words count: 2, data: slithered southward 
Dequeued data: slithered
Words count: 1, data: southward 
Dequeued data: southward
Words count: 0, data: null
```

### Stack Linked List
Last in, first out
- Push and Pop

```
// Place elements into Queue
(Head) 1 -> 2 -> 3 -> nil
// Print out the following:
1 2 3

// Place elements from Queue to Stack
(Top) 3 -> 2 -> 1 -> nil

// Print out the following:
3 2 1
```

## Hacks

### Challenge 1

```java
public class Queue<T> implements Iterable<T> {
    LinkedList<T> head, tail, temp;

    /**
     *  Add a new object at the end of the Queue,
     *
     * @param  data,  is the data to be inserted in the Queue.
     */
    
    //adding data
    public void add(T data) {
        // add new object to end of Queue
        LinkedList<T> tail = new LinkedList<>(data, null);

        if (head == null)  // initial condition
            this.head = this.tail = tail;
        else {  // nodes in queue
            this.tail.setNextNode(tail); // current tail points to new tail
            this.tail = tail;  // update tail
        }
    }

    //deleting data, deletes whole list
  public void delete(){
    // If queue is empty, return NULL.
        if (this.head == null){
            return;
          }
 
        // Store previous front and move front one node ahead
        // T temp = this.head;
        this.head = this.head.getNext();
 
        // If front becomes NULL, then change rear also as NULL
        if (this.head == null){
            this.tail = null;
          }
  }

  public T peek(Queue queue){
        return (T) queue.head.getData();
    }

    /**
     *  Returns the head object.
     *
     * @return  this.head, the head object in Queue.
     */
    public LinkedList<T> getHead() {
        return this.head;
    }

    /**
     *  Returns the tail object.
     *
     * @return  this.tail, the last object in Queue
     */
    public LinkedList<T> getTail() {
        return this.tail;
    }

    /**
     *  Returns the iterator object.
     *
     * @return  this, instance of object
     */
    public Iterator<T> iterator() {
        return new QueueIterator<>(this);
    }
}

/**
 * Queue Iterator
 *
 * 1. "has a" current reference in Queue
 * 2. supports iterable required methods for next that returns a data object
 */
class QueueIterator<T> implements Iterator<T> {
    LinkedList<T> current;  // current element in iteration

    // QueueIterator is intended to the head of the list for iteration
    public QueueIterator(Queue<T> q) {
        current = q.getHead();
    }

    // hasNext informs if next element exists
    public boolean hasNext() {
        return current != null;
    }

    // next returns data object and advances to next position in queue
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
}

/**
 * Queue Manager
 * 1. "has a" Queue
 * 2. support management of Queue tasks (aka: titling, adding a list, printing)
 */
class QueueManager<T> {
    // queue data
    private final String name; // name of queue
    private int count = 0; // number of objects in queue
    public final Queue<T> queue = new Queue<>(); // queue object

    /**
     *  Queue constructor
     *  Title with empty queue
     */
    public QueueManager(String name) {
        this.name = name;
    }

    /**
     *  Queue constructor
     *  Title with series of Arrays of Objects
     */
    
    public QueueManager(String name, T[]... seriesOfObjects) {
        this.name = name;
        this.addList(seriesOfObjects);
        this.deleteList();
    }


    /**
     * Add a list of objects to queue
     */
    
    //from list to linked list
    public void addList(T[]... seriesOfObjects) {
        for (T[] objects: seriesOfObjects)
            for (T data : objects) {
                this.queue.add(data);
                this.printQueue();

              //ok so this basically does nothing
                this.count++;
            }
    }

      public void addListNum(T[]... seriesOfObjects) {
        for (T[] objects: seriesOfObjects)
            for (T data : objects) {
                this.queue.add(data);
              
            }
    }

    //deleting the linked list
  public void deleteList(){
    for (T data : queue){
      this.queue.delete();
      this.printQueue();
      this.count--;
    }
  }

    /**
     * Print any array objects from queue
     */
    public void printQueue() {
        System.out.println(this.name + " count: " + count);
        System.out.print(this.name + " data: ");
        for (T data : queue)
            System.out.print(data + " ");
        System.out.println();
    }
}

/**
 * Driver Class
 * Tests queue with string, integers, and mixes of Classes and types
 */
class QueueTester {
    public static void main(String[] args)
    {
        // Create iterable Queue of Words
        Object[] words = new String[] { "seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
        QueueManager qWords = new QueueManager("Words", words );
       
    }
}

```

### Challenge 2

```java
class MergeTester {
    public static void main(String[] args) {
        // Create iterable Queue of Integers
        Object[] numbers1 = new Integer[]{1, 4, 5, 8};
        Object[] numbers2 = new Integer[]{2, 3, 6, 7};
        MergeManager qNums1 = new MergeManager("First Queue", numbers1);
        qNums1.printQueue();
        MergeManager qNums2 = new MergeManager("Second Queue", numbers2);
        QueueManager qNumsFinal = new QueueManager("Integers");
        qNums2.printQueue();

        
        while (qNums1.queue.count != 0 && qNums2.queue.count != 0) {
            int num1 = (int) qNums1.queue.peek(qNums1.queue);
            int num2 = (int) qNums2.queue.peek(qNums2.queue);
            if (num1 < num2) {
                qNumsFinal.queue.add(num1);
                qNums1.queue.delete(qNums1.queue);
            } else {
                qNumsFinal.queue.add(num2);
                qNums2.queue.delete(qNums2.queue);
            }
        }

        while (qNums1.queue.count != 0) {
            int num1 = (int) qNums1.queue.peek(qNums1.queue);
            qNumsFinal.queue.add(num1);
            qNums1.queue.delete(qNums1.queue);
        }

        while (qNums2.queue.count != 0) {
            int num2 = (int) qNums2.queue.peek(qNums2.queue);
            qNumsFinal.queue.add(num2);
            qNums2.queue.delete(qNums2.queue);

        }
        System.out.print("\nMerged Queue: ");
        qNumsFinal.printQueue();
        System.out.println();
    }
}
```

### Challenge 3

Stack class
```java
public class Stack
{
    private LinkedList lifo;  // last in first out Object of stack

    /**
     *  Constructor for the SinglyLinkedList object
     *  Generates an empty list.
     */
    public Stack()
    {
        lifo = null;
    }

    /**
     *  Returns the current (LIFO) objects value.
     *
     * @return  the current objects value in Stack.
     */
    public Object peek()
    {
        if (lifo == null)
            return null;
        else
            return lifo.getData();
    }

    /**
     *  Inserts a new object at the top of this Stack,
     *
     * @param  value  is the database to be inserted at the top of the Stack.
     */
    public void push(Object value)
    {
        // note the order that things happen:
        // the new object becomes current and gets a value
        // current lifo is parameter, it is assigned as previous node in lifo
        lifo = new LinkedList(value, lifo);
    }

    /**
     *  Removes the top element in the Stack.  Garbage collection should destroy this element when needed.
     *
     */
    public Object pop()
    {
        Object value = null;

        if (lifo != null) {
            value = lifo.getData();
            lifo = lifo.getPrevious();
        }

        return value;
    }

    /**
     *  Returns a string representation of this Stack,
     *  polymorphic nature of toString overrides of standard System.out.print behavior
     *
     * @return    string representation of this list
     */
    public String toString()
    {
        StringBuilder stackToString = new StringBuilder("[");

        LinkedList node = lifo;  				// start from the back
        while (node != null)
        {
            stackToString.append(node.getData()); 	// append the database to output string
            node = node.getPrevious();    		// go to previous node
            if (node != null)
                stackToString.append(", ");
        }										// loop 'till you reach the beginning
        stackToString.append("]");
        return stackToString.toString();
    }


}

```

StackTester class
```java

class StackTester {
    public static void main(String[] args)
    {

        // Creating queue list to add
        Object[] queuestart = new Integer[] { 1, 2, 3};
        Object[] stackfinal = new Integer[] {};
        
        // list to linked list
        QueueManager startq = new QueueManager("Integers", queuestart);

        // print linked list
        startq.printQueue();
        
        // create final linked list
        Stack finals = new Stack();
        
        
        for (int i = 0; i < queuestart.length; i++) {
            finals.push(queuestart[i]);
        }
        System.out.println("\nQueue to Stack:");
        for (int i = 0; i < queuestart.length; i++) {
            System.out.print(finals.pop() + " ");
        }
        System.out.println();

    }
}


```