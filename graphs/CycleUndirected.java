import java.util.*;

public class CycleUndirected {

    public static boolean hasCycle(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, graph, visited)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int nbr : graph.get(node)) {
            if (!visited[nbr]) {
                if (dfs(nbr, node, graph, visited)) return true;
            } else if (nbr != parent) {
                return true;
            }
        }
        return false;
    }
}
