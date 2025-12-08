import java.util.*;

public class TopoSort {

    public List<Integer> topoSort(int n, List<List<Integer>> adj) {
        int[] indegree = new int[n];

        // 1. Compute indegree of every node
        for (int i = 0; i < n; i++) {
            for (int nei : adj.get(i)) {
                indegree[nei]++;
            }
        }

        // 2. Add all nodes with indegree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        // 3. BFS process
        while (!q.isEmpty()) {
            int node = q.remove();
            result.add(node);

            // Decrease indegree of neighbors
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        return result;
    }
}
