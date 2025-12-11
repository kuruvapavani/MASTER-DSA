import java.util.*;

public class ZeroOneBFS {

    public int[] zeroOneBFS(int n, List<List<int[]>> adj, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(src);
        dist[src] = 0;

        while (!dq.isEmpty()) {
            int node = dq.pollFirst();

            for (int[] edge : adj.get(node)) {
                int nei = edge[0];
                int wt = edge[1];

                if (dist[node] + wt < dist[nei]) {
                    dist[nei] = dist[node] + wt;

                    if (wt == 0) dq.addFirst(nei);
                    else dq.addLast(nei);
                }
            }
        }

        return dist;
    }
}
