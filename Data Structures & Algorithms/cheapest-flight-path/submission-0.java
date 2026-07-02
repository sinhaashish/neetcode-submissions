class Solution {

    class Pair {
        int city;
        int cost;

        Pair(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] f : flights) {
            graph.get(f[0]).add(new Pair(f[1], f[2]));
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[src] = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(src, 0));

        int flightsUsed = 0;

        while (!queue.isEmpty() && flightsUsed <= k) {

            int size = queue.size();

            int[] tempCost = Arrays.copyOf(cost, n);

            while (size-- > 0) {

                Pair current = queue.poll();

                for (Pair next : graph.get(current.city)) {

                    int newCost = current.cost + next.cost;

                    if (newCost < tempCost[next.city]) {
                        tempCost[next.city] = newCost;
                        queue.offer(new Pair(next.city, newCost));
                    }
                }
            }

            cost = tempCost;
            flightsUsed++;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}