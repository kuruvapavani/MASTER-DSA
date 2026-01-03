
import java.util.*;

public class MaximumImportance {

    public long maximumImportance(int n, int[][] roads) {
        int[] rank = new int[n];
        int[] degree = new int[n];
        for (int[] r : roads) {
            int a = r[0];
            int b = r[1];
            degree[a]++;
            degree[b]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{i, degree[i]});
        }
        int r = 1;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            rank[node[0]] = r++;
        }
        long ans = 0;
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            ans += rank[a];
            ans += rank[b];
        }
        return ans;
    }
}
