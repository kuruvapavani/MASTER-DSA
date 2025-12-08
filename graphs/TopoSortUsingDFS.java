
import java.util.*;

public class TopoSortUsingDFS {

    public static List<Integer> topoSortUsingDFS(int n, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, st);
            }
        }
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
        return res;
    }

    private static void dfs(List<List<Integer>> adj, int node, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(adj, nei, visited, st);
            }
        }

        st.push(node);
    }

}
