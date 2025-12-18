import java.util.*;

public class KruskalMST {

    static class Edge {
        int u, v, wt;
        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static class DisjointSet {
        int[] parent, rank;

        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;

            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[px] > rank[py]) parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public static int kruskalMST(int n, List<Edge> edges) {
        Collections.sort(edges, (a, b) -> a.wt - b.wt);
        DisjointSet ds = new DisjointSet(n);
        int mstCost = 0;

        for (Edge e : edges) {
            if (ds.find(e.u) != ds.find(e.v)) {
                mstCost += e.wt;
                ds.union(e.u, e.v);
            }
        }
        return mstCost;
    }

    public static void main(String[] args) {
        int n = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        System.out.println(kruskalMST(n, edges));
    }
}
