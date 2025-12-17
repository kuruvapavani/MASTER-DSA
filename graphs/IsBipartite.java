
import java.util.*;

public class IsBipartite {

    public boolean isBipartite(int n, List<List<Integer>> adj) {
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                colors[i] = 0;
                if (bfs(i, adj, visited, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bfs(int src, List<List<Integer>> adj, boolean[] visited, int[] colors) {
        visited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neigh : adj.get(node)) {
                if (!visited[neigh]) {
                    visited[neigh] = true;
                    q.add(neigh);
                    colors[neigh] = 1 - colors[node];
                } else {
                    if (colors[neigh] == colors[node]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
