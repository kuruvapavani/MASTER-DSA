import java.util.*;

public class DFSIterative {
    public static void dfsIterative(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> st = new Stack<>();

        st.push(start);

        while (!st.isEmpty()) {
            int node = st.pop();

            if (visited[node]) continue;
            visited[node] = true;

            System.out.print(node + " ");
            for (int nbr : graph.get(node)) {
                if (!visited[nbr]) {
                    st.push(nbr);
                }
            }
        }
    }
}
