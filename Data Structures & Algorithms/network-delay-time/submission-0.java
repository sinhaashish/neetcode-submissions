class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : times) 
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int node = curr[1];
            // Ignore outdated entries
            if (currDist > dist[node])
                continue;
            for (int[] next : graph[node]) {
                int neighbor = next[0];
                int weight = next[1];
                if (currDist + weight < dist[neighbor]) {
                    dist[neighbor] = currDist + weight;
                    pq.offer(new int[]{ dist[neighbor],neighbor});
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            answer = Math.max(answer, dist[i]);
        }
        return answer;
    }
}