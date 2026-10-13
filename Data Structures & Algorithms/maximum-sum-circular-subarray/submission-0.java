
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int maxSum = nums[0];
        int currentMax = 0;

        int minSum = nums[0];
        int currentMin = 0;

        for (int num : nums) {
            // Maximum subarray sum (Kadane's algorithm)
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Minimum subarray sum
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            total += num;
        }

        // If all numbers are negative, return the largest element
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum circular sum = total - minimum subarray sum
        return Math.max(maxSum, total - minSum);
    }
}
