import java.util.*;

public class PrimMST {

    static class Pair {
        int node, wt;
        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    public static int primMST(int V, List<List<Pair>> adj) {
        boolean[] vis = new boolean[V];
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.wt - b.wt);

        pq.add(new Pair(0, 0));
        int mstCost = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int wt = cur.wt;

            if (vis[node]) continue;
            vis[node] = true;
            mstCost += wt;

            for (Pair nei : adj.get(node)) {
                if (!vis[nei.node]) {
                    pq.add(new Pair(nei.node, nei.wt));
                }
            }
        }
        return mstCost;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(1).add(new Pair(0, 2));

        adj.get(0).add(new Pair(3, 6));
        adj.get(3).add(new Pair(0, 6));

        adj.get(1).add(new Pair(2, 3));
        adj.get(2).add(new Pair(1, 3));

        adj.get(1).add(new Pair(3, 8));
        adj.get(3).add(new Pair(1, 8));

        adj.get(1).add(new Pair(4, 5));
        adj.get(4).add(new Pair(1, 5));

        adj.get(2).add(new Pair(4, 7));
        adj.get(4).add(new Pair(2, 7));

        System.out.println(primMST(V, adj));
    }
}
