# The Ultimate Data Structures & Algorithms Guide
A Comprehensive Data Structures and Algorithms reference guide that originated from a C-based Data Structures and Algorithms course, and have expanded as I have taken more algorithms courses from college and algorithms questions for software engineering interviews. I try to state definitions and examples in my own words to help clarify common questions and precisely compare different algorithms and data structures. I also include other concepts from my upper level algorithms and theory courses to supplement your DS&A knowledge.

### Some of the illustrations below are taken from one of my favorite TA's of all time and [their notes from this class](https://charlierose.dev/ref/cs260.pdf)

### [To bottom](#hard-algorithms)

## Arraylists/Lists/Dynamic Arrays
* O(1) access by index, O(n) by searching (if unsorted)

## Hashtables/Hashmaps/Hashsets/Dictionaries/Lookup Tables
* all of these terms mean the same idea: **map keys to values with O(1) lookup**
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

Stacks are often used with backtracking algorithms and can be used with depth first search. Anything dealing with symbolic computation or notation problems often use stacks.

## Queues
* FIFO (first in, first out), elements are added to the back of the queue
* also implemented as linked list or arraylist
* **add() to the back, remove() from the front**, peek(), and isEmpty() are also O(1), but O(n) search
![Alt text](/images/queue.png)

### Priority Queues
* elements added via comparison and have ordering or weighting to them


## More useful Array algorithms

### Two Pointer
Use two pointers to iterate through an array often bringing array problems from $O(n^2)$ to $O(n)$. This can be done in two ways:
1. Left pointer at the start of the array and right pointer at the end. While left < right, you move through the entire array at once. The Two Sum series, container with most rainwater, and trapping rainwater are great examples.
2. You can use the two pointer approach with linked lists by having a slow and fast pointer (pointer iterating through two nodes at a time) for many linkedlist problems. 

### Sliding Window


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
* collection of **verticies** (nodes) containing data connected through **edges**, $$G = (V, E)$$
* edges can be directed, undirected, weighted, and unweighted
* a **path** is a sequence of vertices connected by edges
* a **cycle** a path where the first and last vertex in a sequence are connected, forming a loop
![Alt text](/images/graph.png)

* an undirected graph has n(n+1)/2 maximum edges while a directed graph has (n+1)n edges both for n nodes
* an undirected graph has sum of all degrees equal to twice the number of edges and for a directed graph it has the sum of all degrees equal to the number of edges

* stored as adjacency list or adjacency matrix where a value or boolean value indicates an edge from node i to j    
![Alt text](/images/adjacencymatrix.png)
* adjacency matricies have a constant O(1) edge lookup, but always uses O(n^2) memory
* adjacency lists have O(n) edge lookup, but best case O(n) memory, worst case O(n^2)

### Breadth First Search
* explore each child before going to any of their children in O(V + E) for V verticies and E edges since we visit every vertex once
  * important detail: runtime is O(V + 2E) for undirected graphs because you visit every edge twice, O(V + E) for directed graphs because you visit every edge once
* add each child to a **queue** and then go through each child
![Alt text](/images/bfs.png)
* better for finding shortest path between 2 nodes than DFS because it discovers verticies in increasing order of distance, and which verticies are reachable from a node (quickly finds its neighbors)
```
def bfs(graph, node):
 visited = {}
 queue = []
 visited.add(node)
 queue.append(node)
 
 while len(queue) > 0:# keep adding to the queue and exploring
   s = queue.pop(0) #s is the current node
   print(s)
   for n in graph[s]: #look at all the neighboring nodes of s
     if n not in visited:
       visited.add(n)
       queue.append(n)
```
* runtime might seem like O(V^2 + E) (also seems like it for depth first search) because we have a nested loop, but in amortized analysis we show you don't actually visit each vertex more than once because the runtime is the degree of the current vertex + 1


### Depth First Search 
* explore each branch completely before moving on to the next branch in O(V + E) for V verticies and E edges
* implemented with a **stack** or recursively
![Alt text](/images/dfs.png)
* better than BFS if we want to visit every node in a graph
* imposes a tree structure of the graph as it visits down a recursion tree

```
 # recursively (better)
 visited = {}
 def dfs(graph, node, visited):
   if node not in visited:
     print(node)
     visited.add(node)
     for n in graph[node]:
       dfs(graph, n, visited)
         
# iteratively
def dfs(graph, node):
  visited = {}
  stack = []
  visited.add(node)
  stack.append(node)
  
  while len(stack) > 0:
    s = stack.pop(0)
    if n not in visited:
      print(s)
      visited.add(n)
    for n in reversed(graph(s)): #because a stack is first in first out, we visit first seen paths
      stack.apppend(n)
```

* when doing a DFS on a directed graph, we can have multiple types of edges (u,v):
  * Tree eges where v was discovered by exploring edge (u,v)
  * Forward edge v is a proper descendant of u (skips ahead in path)
  * **Back edge** where v is an ancestor of u (skips backward in path, points to an edge previously visited of u)
  * Cross edge is where u and v are not ancestors or descendants of one another (edge usually connects between different trees)
* time stamps in a DFS run allow you to determine ancestor/descent relation and if there's any **cycles**
  * **existence of a back edge** proves there's a **cycle** and **no back edges** proves the graph is **acylic**

### Directed Acyclic Graphs
* type of graph (directed and acylic) with a start and an end node useful for describing ordering constraints, precedence, dependencies, etc
* A **Topological Sort** can be performed to sort the verticies of a directed acyclic graph with DFS in O(V+E), so there are no back edges, into a linear ordering of the verticies

![Alt text](/images/DAG.png)
* strongly connected components of a directed graph has every pair of verticies u and v reachable from each other
  * to find them, call DFS to compute finishing times and call DFS again on the graph but invert the directed edges and output the verticies of each tree in the second DFS as a seperate strongly connected component all done in O(V+E)
* Kosaraju's Algorithm gets the number of strongly connected components in O(V)
  * loop through pairs of verticies and see if a grouping of pair of nodes can be reached from each other, if so that grouping is a strongly connected component 

### Minimum Spanning Trees
* tree with minimum total weights that spans all nodes in a weighted graph 
* calculated with a **Greedy Algorithm** by choosing the locally optimal solution
* 2^V possible trees and we want to have V-1 edges in our tree
![Alt-text](/images/mst.PNG)
**Kruskal's Algorithm**
* O(ElogV)
* at each vertex sort edges by weight and include edge in MST if it dosen't form a cycle with the edges already taken (using set unions)
* repeat until there are V-1 edges

**Prim's Algorithm**
* O(ElogV)
* at each vertex add a 2nd vertex connected to the first through a minimum weight edge and keep connecting descendent nodes with smallest edges using a min heap

* both algorithms find a minimum spanning tree in O(ElogV), not the most minimum spanning tree
* Prim's is better if you know nothing about your edges
* Kruskal's is better if your edges are already sorted or somewhat sorted

# Shortest Path Algorithms
Basic ideas:
* sub paths of shortest paths should themselves be shortest paths otherwise the overall path isn't a shortest path
* triangle inequality: 
  * $\delta (s,v) \leq \delta (s,u)+ \delta (u,v)$
  * adding a detour to a path will usually increase the path length than going directly to the destination

### Bellman-Ford Algorithm
* finds shortest path from a source to all other vertices in a weighted graph in O(VE) (with no negative cycles)
* set all nodes to $\infty$
* starts with an estimate and re-examines edges to converge it to the shortest paths
* iterate through all vertices and re-examine all edges
  *set their values to be the shortest path from the source found by adding the values of the previous nodes on the same path
  * we **"Relax"** the edges by comparing the new path and the old path we initially found and choosing the smaller of the paths to set the next node to be, otherwise we don't change the next node
  * **there can only be |V| - 1 edges in a path**, otherwise |V| or more indicates a cycle since we would have a repeated vertex
  * intuitively, after the first iteration we keep checking if the edges offer any improvement to the shortest path 
* ends the program and returns if there exists at least one negative weight cycle
  * a negative cycle implies there dosen't exist a shortest path
* can terminate early depending on how smart you pick the order of edges to traverse if the edges don't improve anything

### Dijkstra's Algorithm
[!Alt-text](https://raw.githubusercontent.com/thelazyaz/data-structures-algorithms/master/images/lovedijk.png)
* finds shortest path from a source to all other vertices in a weighted graph in O(Vlogv + ElogV) (with no negative weights)
* **greedy algorithm** that uses a min heap to select smallest edge to visit
* set all nodes to $\infty$
* examine edges leaving node and choose the smallest edge that hasn't been seen before:
  * gets the smallest edge through extract min with a min heap
    * we also upheap the neighboring edges which takes O(logV) so that extract min is in O(1)
  * set next node to values of shortest path by relaxing the neighboring edges of the min edge we just extracted
     * unlike in Bellman-Ford, we don't relax edges V times, we do it in O(ElogV) for each vertex V
* Dijkstra's dosen't work with negative edges, because once it visits a node it assumes its found the shortest path and won't revisit it
  *which means that if a negative edge exists somewhere it may not be found and Dijkstra's won't create the actual shortest path for vertices that could be shortened with negative edges
  * This is an issue of the Greedy approach since we assumed that the minimality won't changed if we add a number to any vertex path, which is only true for positive numbers
```
def dijkstra(self, start):
   D = {v:float('inf') for v in range(self.v)}
   D[start] = 0

   pq = PriorityQueue()
   pq.put((0, start))
   while not pq.empty():
       (dist, curr) = pq.get()
       self.visited.append(curr)
       for neighbor in range(self.v):
            if self.edges[curr][neighbor] != -1:
                 distance = self.edges[curr][neighbor]
                 if neighbor not in self.visited:
                      old_cost = D[neighbor]
                      new_cost = D[curr] + distance
                      if new_cost < old_cost:
                             pq.put((new_cost, neighbor))
                             D[neighbor] = new_cost
   return D

# for single source shortest path between 2 nodes:
        self.INF = float("inf")
        self.n = n

        adj_list = collections.defaultdict(list)
        for u, v, c in edges:
            adj_list[u].append((v,c))
        self.adj_list = adj_list

   def shortestPath(self, node1: int, node2: int) -> int:
           h = []
           best = [self.INF]*self.n
           heapq.heappush(h, (0, node1))
           best[node1] = 0
   
           while len(h) > 0:
               d, current = heapq.heappop(h)
   
               if current == node2:
                   return d
               if best[current] > d:
                   continue
               for v,c in self.adj_list[current]:
                   if best[v] > d + c:
                       best[v] = d + c
                       heapq.heappush(h, (d + c, v))
           return -1
```
 
### Floyd Warshall Algorithm
* finds the shortest paths between all pairs of vertices in O(V^3) in matrix form
* initialize entries to neighboring edges
* for each pair of nodes find the cost of the shortest path by adding intermediary nodes and see if they improve the shortest path:
  * given $D^{k-1}(u,v)$, we want to see if:
  $$D^{k}(u,v) = D^{k-1}(u,k) + D^{k-1}(k,v)$$
  for an intermediate node k
  * if an intermediary node makes a shorter path we update the shortest path for that pair of verticies u and v
  * else shortest path remains the same
* since each vertex is considered as an intermediary node at some point the algorith runs the calculation in a triple nested for loop:
```
# If D is the adjacency matrix
for v in V:
   for i in V:
     for j in V[0]:
        D[i,j] = min(D[i,j], D[i,k] + D[k, j])
```
* Floyd Warshall can **detect negative cycles** if the **diagonals are negative**
* by comparison, using Dijkstra's to find all pair shortest paths would take O(V^2 * VlogV) and Bellman ford O(V^2 * VE)

_______
***Anything hereafter is beyond the scope of the original class, but does show up in Leetcode and Coding Interview Problems which preparing for is typically the main motivation for most people behind studying these data structures and algorithms***

### Dynamic Programming
* break down a problem into smaller sub-problems (that all depend on each other), store the calculations of those sub-problems in an array or hash table, and then reuse them to find the overall solution
* commonly used whenever you have to find the min/max or optimal of something
* is done through **Memoization** with a recursively called function
Example:
Finding the nth Fibonacci number is the same as the sum of the previous two Fibonacci numbers. With our 2 base cases
```
def fib(n):
   memo = {}
   memo[0] = 0
   memo[1] = 1
   
   def fibHelper(n, memo):
       if n in memo:
           return memo[n]
       else:
           memo[n] = fibHelper(n-1, memo) + fibHelper(n-2, memo)
           return memo[n]
   return fibHelper(n, memo)
```

* is also done with a **Bottom Up** approach where we create an array or hash table, store calculations in it, and iterate through them oftentimes using the index as the key and its calculated value as the value
Example:
For the climbing stairs problem (the same as Fibonacci), you can climb 1 or 2 steps, and to find the distinct number of ways to climb to the top we just reuse the previous two-step calculations
```
def climbStairs(self) -> int:
   dp = [0]*(n+1)
   dp[0] = 1
   dp[1] = 1
   for i in range(2, n+1):
       dp[i] = dp[i-1] + dp[i-2]
   return dp[n]
```

* you'll also notice while Dynamic Programming problems can be the most difficult data structures and algorithms problems, they usually have a very simple and short solution to them
  

### Union Find
* whenever you have a **disjoint** graph or **disjoint** set, this is where Union Find is most naturally used especially for finding number of connected components
* Union merges 2 groups in O(n) by unifying one root node of one group to the root node of the other group to make one of the root nodes be the parent of the other
* Find figures out what group an element belongs to in O(n) by following the parent nodes until a self-loop if reached (a node who's parent is itself)
* You typically:
```
def find(node):
   while node != parent[node]:
      parent[node] = parent[parent[node]]
      node = parent[node]
   return node

def union(node1, node2):
  p1 = find(node1)
  p2 = find(node2)
```
* is also used for path compression
  

# Hard Algorithms
By **hard**, we mean a problem that does not have a polynomial solution to it. Like how when you play chess, you must make a tree of moves. All problems are either decision problems (yes or no answer), or optimization problems (find min or max of something). You can convert an optimization problem to a decision problem if you reword the problem by asking if such an optimization of a value exists. 

Given a problem **P**, if you want to prove its as hard as an NP-Hard problem, you can **reduce** it (reduction itself should be done in polynomial time). Given two problems **A** and **B**:
* if I can convert **A** => **B**
1. If **A** is hard, then **B** is at least as hard
2. If **B** is hard, then we don't know about **A**. We can use a hard problem to solve an easy problem, but we can't use an easy problem to solve a hard problem
3. If **A** is easy, **B** could be anything. Just because you can't solve **A** in polynomial time with **B** dosen't mean you can't use any other polynomial algorithm to try to solve **A**
4. If **B** is easy, **A** is easy

* **NP** is Nondeterministic Polynomial means a **solution** to an NP problem can be **verified in polynomial time** but we don't know if it's solvable in polynomial time
* **NP-Complete** is NP problems that are also as hard as NP-Hard problems. If any NP-complete problem can be solved quickly (in polynomial time), then all problems in NP can also be solved quickly
* **NP-Hard** is a problem at least as hard but can be harder than NP. We don't know if it's solvable or verifiable in P. If you can solve an NP-Hard problem in polynomial time, you can solve all NP problems in polynomial time

* Cook Levin theorem says all NP Problems can be converted into a satisfiability problem

* For proving hardness:
  * Source problem should be as simple and restricted while the target is as hard as possible
   * Source problem should be:
     * 3SAT
     * Integer Partition
     * Vertex Cover
     * Hamiltonian Cycle

## Common NP-Complete Reduction Algorithms:
* 3 Variable Satisfiability (3SAT, or really any SAT):
   * Generate all $2^{n}$ permutations of true/false values for each $k$ variables
   * for each permutation:
      * try the variables to see if they work and if they do, return the permutation
   * $\Theta(2^{n} \cdot k)$ worst case you have to try all $k$ clauses for all $n$ variables
   * $O(2^{n} \cdot n^{3})$ for 3SAT where we have $2n$ choices for $3$ clauses and ~$n^3$ max number of unique clauses from $2n \choose 3$
* Hamiltonian Cycle to Travelling Salesman Problem
   * Hamiltonian Cycle checks if all nodes can be visited once in a graph
      * for every vertex
         * for every vertex
            * if (i, j) $\in E$, w(i, j) = 1 meaning we set the edges in the original graph to 1
            * else w(i, j) = 2 where we set the the introduced edges to 2
    * return Travelling Salesman for size n
    * This reduction algorithm runs in $O(V^{2}$)
* Vertex Cover to independent Set
  * is there a set of $k$ vertices such that every edge contains at least 1 vertex in the set?
  * Invert the edges
  * set $k^{'} = |V| - k$
  * return Independent Set(Inverted Graph, complementary k) where independent set finds an independent set of $k$ vertices
* Independent Set to Max Clique
  * Max Clique asks if a graph has a clique (set of vertices where every pair of vertices defines an edge)
  * Independent Set
    * Invert the graph
    * for every edge (i, j) not in $E$:
       * add (i, j) to inverted edges of inverted graph
    *  Return Clique(inverted graph, k vertices)
* 3SAT to Vertex Cover
  * create $2V$ variables so that each vertex can be either included or not included in the cover to have $n$ variables. Put an edge between each variable and their negation.
  * for each $k$ clauses create "gadgets" that connect the clause vertices in a triangle. Put edge between variable and their places in clause triangle
  * If vertex cover of size $n + 2k$ exists then that implies the original expression is satisfiable
![Alt text](/images/VCexample.gif)
