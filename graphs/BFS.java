
import java.util.*;

public class BFS {

    public static List<Integer> bfs(int start, List<List<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();
        visited[start] = true;
        q.add(start);
        while(!q.isEmpty()){
            int node = q.poll();
            order.add(node);
            for(int nei:graph.get(node)){
                if(!visited[nei]){
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        return order;
    }

}

/*

# ⭐ Graph (Undirected)

Nodes: 0 to 6

Edges:

```
0 - 1
0 - 2
1 - 3
1 - 4
2 - 5
5 - 6
```

Adjacency list:

```
0 → [1,2]
1 → [0,3,4]
2 → [0,5]
3 → [1]
4 → [1]
5 → [2,6]
6 → [5]
```

Start BFS from **0**.

---

# ⭐ Dry Run (Step by Step)

Initial:

```
Q = [0]
visited = {0}
order = []
```

---

### Step 1: Pop 0

```
order = [0]
neighbors: 1, 2
add 1, add 2
```

State:

```
Q = [1,2]
visited = {0,1,2}
```

---

### Step 2: Pop 1

```
order = [0,1]
neighbors: 0 (skip), 3, 4
add 3, add 4
```

State:

```
Q = [2,3,4]
visited = {0,1,2,3,4}
```

---

### Step 3: Pop 2

```
order = [0,1,2]
neighbors: 0 (skip), 5
add 5
```

State:

```
Q = [3,4,5]
visited = {0,1,2,3,4,5}
```

---

### Step 4: Pop 3

```
order = [0,1,2,3]
neighbors: 1 (skip)
nothing added
```

State:

```
Q = [4,5]
```

---

### Step 5: Pop 4

```
order = [0,1,2,3,4]
neighbors: 1 (skip)
```

State:

```
Q = [5]
```

---

### Step 6: Pop 5

```
order = [0,1,2,3,4,5]
neighbors: 2 (skip), 6
add 6
```

State:

```
Q = [6]
visited = {0,1,2,3,4,5,6}
```

---

### Step 7: Pop 6

```
order = [0,1,2,3,4,5,6]
neighbors: 5 (skip)
```

Queue becomes empty.

---

# ⭐ Final BFS Order

```
0, 1, 2, 3, 4, 5, 6
```


 */