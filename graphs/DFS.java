
import java.util.*;

public class DFS {

    public static void dfs(int start, List<List<Integer>> graph, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int nbr : graph.get(start)) {
            if (!visited[nbr]) {
                dfs(nbr, graph, visited);
            }
        }
    }
}

/*

DRY RUN EXAMPLE

Graph:
0 -> 1,2
1 -> 3
2 -> 4
3 -> (empty)
4 -> (empty)

Call: dfs(0)

Steps:

visit 0 → print 0

go to 1

visit 1 → print 1

go to 3

visit 3 → print 3

backtrack

back to 0, go to 2

visit 2 → print 2

go to 4

visit 4 → print 4

done

Output:
0 1 3 2 4

That’s DFS.
 */