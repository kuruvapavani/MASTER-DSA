import java.util.*;

public class ConnectedComponents {

    public static int countComponents(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, graph, visited);
            }
        }
        return count;
    }

    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        Stack<Integer> st = new Stack<>();
        st.push(node);

        while (!st.isEmpty()) {
            int curr = st.pop();
            if (visited[curr]) continue;
            visited[curr] = true;

            for (int nbr : graph.get(curr)) {
                if (!visited[nbr]) {
                    st.push(nbr);
                }
            }
        }
    }
}

/*

Quick Example

Graph with 5 nodes:

0 ↔ 1
2 ↔ 3
(4 alone)

Components:
• {0,1}
• {2,3}
• {4}

Total = 3

DFS runs three times because:

first from 0 marks {0,1}

then 2 marks {2,3}

then 4 marks {4}

 */