class Solution {

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries,
                (a, b) -> Integer.compare(a[0], b[0]));
        int[] answer = new int[m];
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) ->
                        Integer.compare(a[0], b[0]));
        // [length, end]
        int i = 0;
        for (int[] query : sortedQueries) {
            int value = query[0];
            int index = query[1];
            // Add all intervals whose start <= query
            while (i < intervals.length && intervals[i][0] <= value) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int length = right - left + 1;
                pq.offer(new int[]{length, right});
                i++;
            }
            // Remove expired intervals
            while (!pq.isEmpty() &&
                    pq.peek()[1] < value) {
                pq.poll();
            }
            answer[index] =
                    pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return answer;
    }
}