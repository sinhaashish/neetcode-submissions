class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if ( n==1) {
            return nums[0];
        }

        return Math.max(robLinear( nums, 0, n-2), robLinear( nums, 1, n-1));
        
    }

    public int robLinear( int[] nums, int start , int end) {
        int length = end - start +1;
        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = nums[start];
        for ( int i = 2; i <= length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+ nums[start + i-1]);
        }
        return dp[length];
    }
}
