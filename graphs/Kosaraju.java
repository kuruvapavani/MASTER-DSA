
import java.util.*;

class Kosaraju {

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();

        // Step 1: order by finish time
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, adj, visited, st);
            }
        }

        // Step 2: reverse graph
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            rev.add(new ArrayList<>());
        }

        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                rev.get(v).add(u);
            }
        }

        // Step 3: DFS on reversed graph
        Arrays.fill(visited, false);
        int sccCount = 0;

        while (!st.isEmpty()) {
            int node = st.pop();
            if (!visited[node]) {
                dfs2(node, rev, visited);
                sccCount++;
            }
        }

        return sccCount;
    }

    private void dfs1(int node, ArrayList<ArrayList<Integer>> adj,
            boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs1(nei, adj, visited, st);
            }
        }
        st.push(node);
    }

    private void dfs2(int node, ArrayList<ArrayList<Integer>> rev,
            boolean[] visited) {
        visited[node] = true;
        for (int nei : rev.get(node)) {
            if (!visited[nei]) {
                dfs2(nei, rev, visited);
            }
        }
    }
}
