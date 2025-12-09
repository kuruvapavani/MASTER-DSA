
import java.util.*;

public class ShortestPath {

    public List<Integer> shortestPath(int n, List<List<Integer>> adj, int src, int dest) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == dest) {
                break;
            }
            for (int neigh : adj.get(node)) {
                if (parent[neigh] == -1 && neigh != src) {
                    parent[neigh] = node;
                    q.add(neigh);
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        if (parent[dest] == -1 && dest != src) {
            return path;
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
