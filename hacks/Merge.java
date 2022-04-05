import java.util.Iterator;

/**
 * Queue Manager
 * 1. "has a" Queue
 * 2. support management of Queue tasks (aka: titling, adding a list, printing)
 */
class MergeManager<T> {
    // queue data
    private final String name; // name of queue
    private int count = 0; // number of objects in queue
    public final Queue<T> queue = new Queue<>(); // queue object

    /**
     *  Queue constructor
     *  Title with empty queue
     */
    public MergeManager(String name) {
        this.name = name;
    }

    /**
     *  Queue constructor
     *  Title with series of Arrays of Objects
     */
    public MergeManager(String name, T[]... seriesOfObjects) {
        this.name = name;
        this.addList(seriesOfObjects);
    }


    /**
     * Add a list of objects to queue
     */
    public void addList(T[]... seriesOfObjects) {
        for (T[] objects: seriesOfObjects)
            for (T data : objects) {
                this.queue.add(data);
              //ok so this basically does nothing
                this.count++;
            }
    }


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

class MergeTester{
  public static void main(String[] args){
    // Create iterable Queue of Integers
        Object[] numbers1 = new Integer[] { 1, 4, 5, 8};
      Object[] numbers2 = new Integer[] { 2, 3, 6, 7};
        MergeManager qNums1 = new MergeManager("First Queue", numbers1 );
    qNums1.printQueue();
      MergeManager qNums2 = new MergeManager("Second Queue", numbers2 );
     QueueManager qNumsFinal = new QueueManager("Integers");
    qNums2.printQueue();

    // while (qNums1.queue.count != 0 && qNums2.queue.count != 0) {
    //         int num1 = (int)qNums1.queue.peek(qNums1.queue);
    //         int num2 = (int)qNums2.queue.peek(qNums2.queue);
    //         if (num1 < num2) {
    //             qNumsFinal.queue.add(num1);
    //             qNums1.queue.delete(qNums1.queue);
    //         } else {
    //             qNumsFinal.queue.add(num2);
    //             qNums2.queue.delete(qNums2.queue);
    //         }
    //     }

    //     while (qNums1.queue.count != 0) {
    //         int num1 = (int)qNums1.queue.peek(qNums1.queue);
    //             qNumsFinal.queue.add(num1);
    //             qNums1.queue.delete(qNums1.queue);
    //     }

    //     while (qNums2.queue.count != 0) {
    //         int num2 = (int)qNums2.queue.peek(qNums2.queue);
    //             qNumsFinal.queue.add(num2);
    //             qNums2.queue.delete(qNums2.queue);

    //     }
    //     System.out.print("\nMerged Queue: ");
    //     qNumsFinal.printQueue();
    //     System.out.println();
  }
}