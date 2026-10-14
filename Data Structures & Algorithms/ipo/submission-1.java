

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        // Min-heap: projects sorted by required capital
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0], b[0]));
        // Store {required capital, profit}
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[] {capital[i], profits[i]});
        }
        // Max-heap: highest profit first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        // Choose at most k projects
        for (int i = 0; i < k; i++) {
            // Add every project we can currently afford
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                int[] project = minHeap.poll();
                maxHeap.offer(project[1]);
            }
            // No affordable projects remain
            if (maxHeap.isEmpty()) {
                break;
            }
            // Select the affordable project with maximum profit
            w += maxHeap.poll();
        }

        return w;
    }
}
