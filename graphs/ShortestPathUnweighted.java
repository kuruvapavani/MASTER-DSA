import java.util.*;

public class ShortestPathUnweighted {

    public int[] shortestPath(int n, List<List<Integer>> adj, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int node = q.remove();

            for (int nei : adj.get(node)) {
                if (dist[nei] == -1) { 
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                }
            }
        }

        return dist;
    }
}
