# Data Structures & Algorithms
Data Structures and Algorithms I've implemented myself in Python and Java for coding interview preparation

## Arraylists/Lists/Dynamic Arrays
* O(1) access by index, O(n) by searching (if unsorted)

## Hashtables/Hashmaps/Hashsets/Dictionaries
* maps keys to values with O(1) lookup 
* stored in linkedlists or arraylists to avoid collisions, known as **chaining** with an **Open Hash Table**, or use **open addressing** to associate keys with sequences and store the new key in the next open item in the sequence with a **Closed Hash Table** (though you need to double the size and rehash values if you run out of space)
* put (key, value) into hash table and get(key) value 
![Alt text](/images/hashtable.png)

* Dictionaries are just Hash Tables without a hash function, just the literal string key mapping to a value
* Useful for identifying duplicates or keeping track of only distinct values

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

## Sorting & Searching Algorithms
Essential:
### Merge Sort
* O(n log (n))
* divide array in half, sorts each half and then merge sorts the halves of those halves,... merge sort the halves until you end up merge sorting single element arrays
![Alt text](/images/mergesort.png)
* the log (n) comes from the dividing of the array in half, and the n comes from having to lineary search the halves for out of order pairs as you merge them back together

### Quick Sort
* O(n log (n)), but O(n^2) worst case
* pick random element and use it to partition the array such that all elements that are less than the partition come before and all elements greater come after. Repeatedly partioning the array will become sorted, as you swap any elements out of order
![Alt text](/images/quicksort.png)
* Quick Sort does everything in place and is **much more memory efficient than merge sort**

### Radix Sort
* O(kn) for k passes
* iterate through each digit and group numbers together by each digit
![Alt text](/images/radixsort.png)

### Linear Search
* O(n)
### Binary Search
* O(log (n))
* only for sorted arrays & lists

Nice to Know:
### Bubble Sort
* O(n^2)
* start at the beginning and swap first two elements if first is greater than the 2nd, then do the same while iterating through the rest of the pairs
### Selection Sort
* O(n^2)
* find smallest element with a linear scan and move it to the front, then do the same for the 2nd smallest, 3rd,...nth smallest untill the elements are in place

## Trees
* Hierarchical data structure with root node having zero or more child nodes, and each child node has zero or more child nodes,...
* acyclic graphs with n-1 edges for n nodes
* leafs are the nodes with no children
* depth is the number of edges from the root, height is the number of edges from the nearest leaf, tree has an overal height as the number of edges from the deepest leaf to the root
![Alt text](/images/tree.png)

* Binary trees have at most 2 children and the following properties:
  * **Complete** binary tree has every level fully filled with children except possibly the last level which is filled left to right
  * **Full** binary trees have all nodes with either 0 or 2 children, but never 1
  * **Perfect** binary trees have all nodes with 2 children and all leafs are at the same level

* 3 ways to traverse a tree (do this recursively):
  * Preorder: Node, Left, Right
  * Inorder: Left, Node, Right
  * Postorder: Left, Right, Node


### Binary Search Trees
* binary tree with every node has its left descendants less than or equal to itself, and its right descendants greater than or equal to itself
* O(logn) search
![Alt text](/images/bst.png)

* to delete a node with 2 children, replace the node with either the minimum of the left subtree or maximum of the right subtree; either takes O(n)
* perfect BST has height = 2^(n+1) -1 nodes, for n nodes

### Red-Black Trees
* **self balancing** binary search tree

![Alt text](/images/red-blacktrees.png)

1. every node is red or black
2. **root** is **black**
3. **every leaf** is **null and black**
4. **red node** has **both** its **children black**
5. all paths from a node to a leaf have same the number of black nodes in between (black-height is constant)

* rotating red black tree is done in O(1) pointer operations
* to insert a node, color it red
  * if insertion causes violation, in one of 3 cases, move violating node up tree until its fixed

### Heaps
* complete binary tree (filled left to right, except for maybe the last level) where each node is either smaller (**Min Heap**) or greater (**Max Heap**) than its children
  * this is a max heap ↓
  
![This is a max heap](/images/heap.png)
* for a min heap, the root is the minimum, for a max heap the root is the maximum
![Alt text](/images/heapshape.png)

* useful for fast min/max computations in O(1)
* O(n) initialization and O(logn) insertion and deletion
  * we need to bubble elements up/down with a min/max heapify recursive function (also called upheaping and downheaping)


### Huffman Coding Tree
* store characters and their frequencies of a string in a min heap; typically implemented as an array
  * repeatedly remove the 2 smallest nodes in the heap and create a parent node to combine them and insert the parent node back into the heap
  * your heap should have 1 node at the end which is the root node to your huffman tree, located at the first index (the other indicies are merely pointers)
* once you built your tree, generate codes for each character by going down the tree and concatenating a 0 for a left child and 1 for a right child until you reach a leaf; then use your code table to encode a value
![Alt text](/images/huffmantree.png)


### Tries
* n-array tree with each node a character of the alphabet, with paths down the tree representing words
* are implemented with additional terminating nodes to indicate the end of a word down a path
* useful for checking if something is a valid prefix. Ex. if you store the English language in a trie, then you can easily look up if a string is a prefix of another string in O(n) time where n is the length of the string  
![Alt text](/images/trie.png)


## Graphs
* collection of **verticies** (nodes) containing data connected through **edges**
* edges can be directed, undirected, weighted, and unweighted
* a **path** is sequential vertices connected by edges
* a **cycle** a path with repeated vertices
![Alt text](/images/graph.png)

* stored as adjacency list or adjacency matrix where a value or boolean value indicates an edge from node i to j    
![Alt text](/images/adjacencymatrix.png)
* adjacency matricies have a constant O(1) edge lookup, but always uses O(n^2) memory
* adjacency lists have O(n) edge lookup, but best case O(n) memory, worst case O(n^2)

### Breadth First Search
* explore each child before going to any of their children in O(m + n) for m verticies and n edges
* add each child to a **queue** and then go through each child
![Alt text](/images/bfs.png)
* better for finding shortest path between 2 nodes because it discovers verticies in increasing order of distance, and which verticies are reachable from a node (quickly finds its neighbors)
### Depth First Search
* explore each branch completely before moving on to the next branch in O(m + n) for m verticies and n edges
* implemented with a **stack** or recursively
![Alt text](/images/dfs.png)
* better if we want to visit every node in a graph
