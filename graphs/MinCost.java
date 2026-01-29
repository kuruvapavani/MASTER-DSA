
import java.util.*;

public class MinCost {

    public long minimumCost(String s, String t, char[] original, char[] changed, int[] cost) {
        int INF = (int) 1e9;
        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int from = s.charAt(i) - 'a';
            int to = t.charAt(i) - 'a';

            if (dist[from][to] == INF) {
                return -1;
            }
            ans += dist[from][to];
        }

        return ans;
    }

}
