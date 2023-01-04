# Data Structures & Algorithms
Data Structures and Algorithms I've implemented myself in Python and Java for coding interview preparation


## Arraylists/Lists/Dynamic Arrays
* O(1) access by index, O(n) by searching (if unsorted)

## Hashtables/Hashmaps/Hashsets/Dictionaries
* maps keys to values (stored in linkedlists or arraylists to avoid collisions, known as **chaining**) with O(1) lookup
* put (key, value) into hash table and get(key) value 
![Alt text](/images/hashtable.png)

## Linked Lists
* non contigous sequence of nodes that hold data and point to the next node (and previous node if working with a doubly linked list)
* O(n) access to the nth element, but O(1) inserting/removing elements from the beginning of the list
![Alt text](/images/linkedlist.png)
![Alt text](/images/doublylinkedlist.png)

# Stacks
* LIFO (last on, first off), elements are added on top of the stack
* implemented as linked list or arraylist
* **pop() and push() from the top**, peek(), and isEmpty() are O(1), but O(n) to access a certain element
![Alt text](/images/stack.png)

# Queues
* FIFO (first in, first out), elements are added to the back of the queue
* also implemented as linked list or arraylist
* **add() to the back, remove() from the front**, peek(), and isEmpty() are also O(1), but O(n) search
![Alt text](/images/queue.png)

## Priority Queues
* elements added via comparison and have ordering or weighting to them
