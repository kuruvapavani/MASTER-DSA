
import java.util.*;

public class CriticalConnections {

    private int timer;
    private int[] tin, low;
    private boolean[] visited;
    private List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        timer = 0;
        tin = new int[n];
        low = new int[n];
        visited = new boolean[n];
        bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj);
            }
        }

        return bridges;
    }

    private void dfs(int node, int parent, List<List<Integer>> adj) {
        visited[node] = true;
        tin[node] = low[node] = timer++;

        for (int neigh : adj.get(node)) {
            if (neigh == parent) {
                continue;
            }

            if (!visited[neigh]) {
                dfs(neigh, node, adj);
                low[node] = Math.min(low[node], low[neigh]);

                if (low[neigh] > tin[node]) {
                    bridges.add(Arrays.asList(node, neigh));
                }
            } else {
                low[node] = Math.min(low[node], tin[neigh]);
            }
        }
    }
}
