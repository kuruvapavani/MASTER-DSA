import java.util.*;

public class ArticulationPoints {

    private int timer;
    private int[] tin, low;
    private boolean[] visited;
    private boolean[] isArticulation;

    public List<Integer> articulationPoints(int n, List<List<Integer>> adj) {
        timer = 0;
        tin = new int[n];
        low = new int[n];
        visited = new boolean[n];
        isArticulation = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isArticulation[i]) res.add(i);
        }
        return res;
    }

    private void dfs(int u, int parent, List<List<Integer>> adj) {
        visited[u] = true;
        tin[u] = low[u] = timer++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == parent) continue;

            if (!visited[v]) {
                dfs(v, u, adj);
                low[u] = Math.min(low[u], low[v]);

                if (parent != -1 && low[v] >= tin[u]) {
                    isArticulation[u] = true;
                }
                children++;
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }

        if (parent == -1 && children > 1) {
            isArticulation[u] = true;
        }
    }
}
