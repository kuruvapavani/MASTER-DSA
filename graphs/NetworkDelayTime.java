
import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];
            adj.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int t = curr[1];
            for (int[] nei : adj.get(u)) {
                int v = nei[0];
                int t2 = nei[1];
                if (dist[v] > dist[u] + t2) {
                    dist[v] = dist[u] + t2;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }

}
