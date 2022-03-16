## Tech Talk 1 : Linked Lists

Linked lists: A way of keeping and managing a list of objects
- Generic data
- ForEach loop support

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