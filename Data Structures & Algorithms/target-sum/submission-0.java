class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }

        if ((target + totalSum) % 2 != 0) {
            return 0;
        }

        int sum = (target + totalSum) / 2;
        int n = nums.length;

        int[][] dp = new int[n + 1][sum + 1];
        
	    for (int i = 0; i <= n; i++) {
		    for (int j = 0; j <= sum; j++) {
			    if (i == 0) {
				    dp[i][j] = 0;
                }
			    if (j == 0) {
				    dp[i][j] = 1;
                }
		    }
	    }
	    for (int i = 1; i <= n; i++) {
		    for (int j = 0; j <= sum; j++) {
			    if (nums[i - 1] <= j) {
				    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j]; 
                } else {
				    dp[i][j] = dp[i - 1][j];
                }
		    }
	    }
	    return dp[n][sum]; 
    }
}
