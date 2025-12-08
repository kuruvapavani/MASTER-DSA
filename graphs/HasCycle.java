
import java.util.List;

public class HasCycle {

    public boolean hasCycle(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        boolean[] st = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, st, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, boolean[] visited, boolean[] st, List<List<Integer>> graph) {
        visited[node] = true;
        st[node] = true;

        for (int neigh : graph.get(node)) {
            if (!visited[neigh]) {
                if (dfs(neigh, visited, st, graph)) {
                    return true;
                }
            } else if (st[neigh]) {
                return true;
            }
        }

        st[node] = false;
        return false;
    }
}
