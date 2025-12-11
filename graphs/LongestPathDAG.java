import java.util.*;

public class LongestPathDAG {

    public List<Integer> longestPathDAG(int n, List<List<Integer>> adj, int src) {
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        dfs(src, adj, dp, parent);

        List<Integer> path = new ArrayList<>();
        int curr = src;
        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }
        return path;
    }

    private int dfs(int node, List<List<Integer>> adj, int[] dp, int[] parent) {
        if (dp[node] != 0) return dp[node];

        int best = 1;

        for (int nei : adj.get(node)) {
            int candidate = 1 + dfs(nei, adj, dp, parent);

            if (candidate > best) {
                best = candidate;
                parent[node] = nei;
            }
        }

        dp[node] = best;
        return best;
    }
}
