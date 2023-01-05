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

## Stacks
* LIFO (last on, first off), elements are added on top of the stack
* implemented as linked list or arraylist
* **pop() and push() from the top**, peek(), and isEmpty() are O(1), but O(n) to access a certain element
![Alt text](/images/stack.png)

## Queues
* FIFO (first in, first out), elements are added to the back of the queue
* also implemented as linked list or arraylist
* **add() to the back, remove() from the front**, peek(), and isEmpty() are also O(1), but O(n) search
![Alt text](/images/queue.png)

### Priority Queues
* elements added via comparison and have ordering or weighting to them

## Trees
* Hierarchical data structure with root node having zero or more child nodes, and each child node has zero or more child nodes,...
* acyclic graphs
* leafs are the nodes with no children
* depth is the number of edges from the root, height is the number of edges from the nearest leaf, tree has an overal height as the number of edges from the deepest leaf to the root
![Alt text](/images/tree.png)

* Binary trees have at most 2 children and the following properties:
  * Complete binary tree has every level fully filled with children except possibly the last level which is filled left to right
  * Full binary trees have all nodes with either 0 or 2 children, but never 1
  * Perfect binary trees have all nodes with 2 children and all leafs are at the same level


### Binary Search Trees
* binary tree with every node has its left descendants less than or equal to itself, and its right descendants greater than or equal to itself
![Alt text](/images/bst.png)

### Heaps
* complete binary tree (filled left to right, except for maybe the last level) where each node is either smaller (Min Heap) or greater (Max Heap) than its children
  * this is a max heap ↓
  
![This is a max heap](/images/heap.png)
* for a min heap, the root is the minimum, for a max heap the root is the maximum
![Alt text](/images/heapshape.png)

### Tries
* n-array tree with each node a character of the alphabet, with paths down the tree representing words
* are implemented with additional terminating nodes to indicate the end of a word down a path
* useful for checking if something is a valid prefix. Ex. if you store the English language in a trie, then you can easily look up if a string is a prefix of another string in O(n) time where n is the length of the string  
![Alt text](/images/trie.png)


## Graphs
* collection of nodes, vertices, containing data connected through edges
* edges can be directed (one way travel and hierarchy) or undirected where travel is allowed in both directions
* a **path** is sequential vertices connected by edges
* a **cycle** a path with repeated vertices
![Alt text](/images/graph.png)

* stored as adjacency list or adjacency matrix where a value or boolean value indicates an edge from node i to j    
![Alt text](/images/adjacencymatrix.png)

### Breadth First Search
* explore each child before going to any of their children
* add each child to a **queue** and then go through each child
![Alt text](/images/bfs.png)
* better for finding shortest path between 2 nodes

### Depth First Search
* explore each branch completely before moving on to the next branch
* implemented recursively   
![Alt text](/images/dfs.png)
* better if we want to visit every node in a graph