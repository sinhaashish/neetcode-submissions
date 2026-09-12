class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];

        // Initially, all airports are unreachable
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        cost[src] = 0;

        // k stops = k + 1 flights
        for (int i = 0; i <= k; i++) {
            int[] temp = cost.clone();

            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                // If 'from' is unreachable, skip it
                if (cost[from] == Integer.MAX_VALUE) {
                    continue;
                }

                temp[to] = Math.min(temp[to], cost[from] + price);
            }

            cost = temp;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}