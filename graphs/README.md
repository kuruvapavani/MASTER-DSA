# Graphs – Interview Quick Reference (DSA)

---

## 1. Graph Basics

**Graph = Nodes (V) + Edges (E)**

### Types

* Undirected / Directed
* Weighted / Unweighted
* Cyclic / Acyclic

### Representation (Always Preferred)

```java
List<List<Integer>> adj = new ArrayList<>();
```

Why adjacency list:

* Space efficient
* Faster traversal
* Works for sparse graphs (most interview cases)

---

## 2. Traversals

### BFS (Breadth First Search)

* Uses **Queue**
* Level by level traversal
* Gives **shortest path in unweighted graph**

Used for:

* Shortest path (unweighted)
* Level order traversal
* Bipartite check

Time: `O(V + E)`

---

### DFS (Depth First Search)

* Uses **Recursion / Stack**
* Goes deep before backtracking

Used for:

* Cycle detection
* Connected components
* Topological sort
* Bridges / articulation points

Time: `O(V + E)`

---

## 3. Cycle Detection

### Undirected Graph

* DFS + parent tracking
* If visited neighbor ≠ parent → cycle

### Directed Graph

* DFS + recursion stack
* Use:

  * `visited[]`
  * `pathVisited[]`
* If neighbor already in path → cycle

---

## 4. Connected Components

Approach:

* Loop through all nodes
* If node not visited → start DFS/BFS
* Count number of starts

Used when problem says:

* Number of groups / provinces / islands
* Is graph fully connected?

---

## 5. Bipartite Graph

Definition:

* Graph that can be colored using **2 colors**
* No two adjacent nodes have same color

Approach:

* BFS/DFS + color array
* If conflict → not bipartite

Common disguises:

* Divide into two groups
* Possible assignment

---

## 6. Topological Sort (DAG only)

### Methods

1. DFS + Stack
2. Kahn’s Algorithm (BFS + indegree)

Conditions:

* Works **only on Directed Acyclic Graphs**
* If cycle exists → topo sort impossible

Used for:

* Course Schedule
* Task dependency
* Build order

---

## 7. Shortest Path Algorithms

### Unweighted Graph

* **BFS**

### Weighted Graph

* **Dijkstra** → no negative weights
* **Bellman Ford** → allows negative weights
* **Floyd Warshall** → all pairs (rare)

Dijkstra:

* Uses Min Heap (PriorityQueue)
* Time: `O((V+E) log V)`

---

## 8. Minimum Spanning Tree (MST)

Goal:

* Connect all nodes with minimum total cost

### Kruskal’s Algorithm

* Sort edges by weight
* Use Disjoint Set (Union-Find)

### Prim’s Algorithm

* Start from any node
* Expand using min edge (like Dijkstra)

Condition:

* Graph must be connected

---

## 9. Disjoint Set (Union-Find)

Operations:

* `findParent()`
* `union()`

Optimizations:

* Path compression
* Union by rank

Used in:

* Kruskal’s MST
* Cycle detection
* Dynamic connectivity

---

## 10. Bridges & Articulation Points

Based on:

* DFS
* Discovery time
* Low time

### Bridge

* Edge whose removal disconnects graph

### Articulation Point

* Node whose removal disconnects graph

Important for:

* Network reliability
* Critical connections

---

## 11. Strongly Connected Components (SCC)

Definition:

* In directed graph, every node reachable from every other node

### Kosaraju Algorithm

1. DFS and store finish order
2. Reverse graph
3. DFS in stack order

Used when:

* Mutual reachability
* Grouping nodes in directed graph

---

## 12. Pattern Recognition Cheat Sheet

| Problem Statement          | Technique        |
| -------------------------- | ---------------- |
| Shortest path (unweighted) | BFS              |
| Shortest path (weighted)   | Dijkstra         |
| Dependencies / order       | Topological Sort |
| Cycle exists?              | DFS              |
| Minimum cost to connect    | MST              |
| Groups / islands           | DFS / BFS        |
| Mutual reachability        | SCC              |

---
