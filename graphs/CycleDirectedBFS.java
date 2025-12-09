import java.util.*;

public class CycleDirectedBFS {

    public boolean hasCycle(int n, List<List<Integer>> adj) {
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int nei : adj.get(i)) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.remove();
            count++;

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return count != n;
    }
}
