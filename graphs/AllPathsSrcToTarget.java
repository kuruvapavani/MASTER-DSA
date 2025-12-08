
import java.util.*;

public class AllPathsSrcToTarget {

    public static List<List<Integer>> allPathsSrcToTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0); // start from node 0
        dfs(graph, 0, path, ans);

        return ans;
    }

    public static void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> ans) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));  // add a copy
            return;
        }

        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, next, path, ans);
            path.remove(path.size() - 1); // backtrack
        }
    }
}
