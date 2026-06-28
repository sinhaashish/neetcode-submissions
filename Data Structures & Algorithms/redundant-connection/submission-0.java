class Solution {

    class DSU {

        int[] parent;
        int[] rank;

        DSU(int n) {

            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i <= n; i++)
                parent[i] = i;
        }

        int find(int x) {

            if (parent[x] != x)
                parent[x] = find(parent[x]); // Path compression

            return parent[x];
        }

        void union(int x, int y) {

            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] < rank[py]) {

                parent[px] = py;

            } else if (rank[px] > rank[py]) {

                parent[py] = px;

            } else {

                parent[py] = px;
                rank[px]++;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        DSU dsu = new DSU(n);

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            if (dsu.find(u) == dsu.find(v))
                return edge;

            dsu.union(u, v);
        }

        return new int[0];
    }
}