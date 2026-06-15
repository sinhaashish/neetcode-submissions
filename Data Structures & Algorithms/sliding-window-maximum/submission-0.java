class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[] ans = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {

            pq.offer(new int[]{nums[i], i});

            if (i >= k - 1) {

                while (!pq.isEmpty() && pq.peek()[1] <= i - k) {
                    pq.poll();
                }

                ans[idx++] = pq.peek()[0];
            }
        }

        return ans;
    }
}