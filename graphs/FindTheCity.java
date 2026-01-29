
import java.util.*;

public class FindTheCity {

    public int findTheCity(int n, int[][] edges, int d) {
        int INF = (int) 1e9;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int ans = -1;
        int minCount = n + 1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] != INF && dist[i][j] <= d) {
                    count++;
                }
            }
            if (count <= minCount) {
                ans = Math.max(ans, i);
                minCount = Math.min(minCount, count);
            }
        }
        return ans;
    }

}
