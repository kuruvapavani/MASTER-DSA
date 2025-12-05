import java.util.*;

public class FindKClosest {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> distance(b) - distance(a)
        );

        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }

        return ans;
    }

    private int distance(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
}
