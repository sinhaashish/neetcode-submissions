class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        // Store: {enqueueTime, processingTime, originalIndex}
        int[][] sortedTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        // Sort tasks by enqueue time
        Arrays.sort(sortedTasks, new Comparator<int[]>() {
            public int compare(int[] x, int[] y) { return Integer.compare(x[0], y[0]); }
        });
        // Min-heap: shortest processing time, then smallest index
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            new Comparator<int[]>() {
                public int compare(int[] x, int[] y) {
                    if (x[1] != y[1]) { return Integer.compare(x[1], y[1]); }
                    return Integer.compare(x[2], y[2]);
                }
            }
        );
        int[] result = new int[n]; int resultIndex = 0; int i = 0; long time = 0;
        while (i < n || !pq.isEmpty()) {
            // If no task is available, move time to the next task
            if (pq.isEmpty() && i < n && time < sortedTasks[i][0]) {
                time = sortedTasks[i][0];
            }
            // Add all tasks that have arrived
            while (i < n && sortedTasks[i][0] <= time) {
                pq.offer(sortedTasks[i]); i++;
            }
            // Execute the task with the shortest processing time
            int[] task = pq.poll();
            result[resultIndex++] = task[2];
            // CPU finishes this task at this time
            time += task[1];
        }
        return result;
    }
}