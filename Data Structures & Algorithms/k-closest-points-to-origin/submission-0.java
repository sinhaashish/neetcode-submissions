class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    int distA = a[0] * a[0] + a[1] * a[1];
                    int distB = b[0] * b[0] + b[1] * b[1];

                    return distB - distA; // max heap
                }
            }
        );
        for (int[] point : points) {
            pq.offer(point);

            if (pq.size() > k) {
                pq.poll(); // remove farthest
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

}

