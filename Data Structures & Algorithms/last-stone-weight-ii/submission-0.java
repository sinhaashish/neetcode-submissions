class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;

        for (int stone : stones) {
            total += stone;
        }

        int target = total / 2;

        // dp[j] = maximum sum we can make that is <= j
        int[] dp = new int[target + 1];

        for (int stone : stones) {
            for (int j = target; j >= stone; j--) {
                dp[j] = Math.max(dp[j], dp[j - stone] + stone);
            }
        }

        // One group has sum dp[target].
        // The other group has sum total - dp[target].
        return total - 2 * dp[target];
    }
}