import java.util.*;

public class DijkstraAlgo {

    public List<Integer> dijkstra(int n, List<List<int[]>> adj, int src, int dest) {

        int[] dist = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];

            if (visited[node]) continue;
            visited[node] = true;

            if (node == dest) break;

            for (int[] neigh : adj.get(node)) {
                int next = neigh[0];
                int wt = neigh[1];

                if (dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    parent[next] = node;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        // Build path from dest → src using parent[]
        List<Integer> path = new ArrayList<>();

        if (dist[dest] == Integer.MAX_VALUE) {
            return path; // no path exists
        }

        int curr = dest;
        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }

        Collections.reverse(path);
        return path;
    }
}
