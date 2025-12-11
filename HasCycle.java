import java.util.*;

public class HasCycle {

    public boolean hasCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited)) return true;
            }
        }
        return false;
    }

    private boolean bfs(int src, List<List<Integer>> adj, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        // pair: [node, parent]
        q.add(new int[]{src, -1});
        visited[src] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int node = p[0];
            int parent = p[1];

            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(new int[]{neigh, node});
                } 
                else if (neigh != parent) {
                    return true;   // visited but not parent → cycle
                }
            }
        }
        return false;
    }
}
