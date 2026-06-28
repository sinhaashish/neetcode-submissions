class Solution {

    public int countComponents(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        // Build graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];

        int components = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                dfs(i, graph, visited);
                components++;
            }
        }

        return components;
    }

    private void dfs(int node,
                     List<Integer>[] graph,
                     boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph[node]) {

            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}