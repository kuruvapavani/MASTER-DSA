
import java.util.*;




class BellmanFord {

    static class Edge {

        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    public int[] bellmanFord(int n, List<Edge> edges, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges n-1 times
        for (int i = 1; i <= n - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE
                        && dist[e.u] + e.wt < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.wt;
                }
            }
        }

        // Check negative cycle
        for (Edge e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE
                    && dist[e.u] + e.wt < dist[e.v]) {
                throw new RuntimeException("Negative cycle detected");
            }
        }

        return dist;
    }
}
