class Solution {
    public int lengthOfLIS(int[] nums) {
        Set<Integer> hs = new TreeSet();
        for ( int num : nums) {
            hs.add(num);
        }
        int[] increasedArray = new int[hs.size()];
        int index =0;
        for (int num : hs) {
            increasedArray[index++] = num;
        }       

        int m = nums.length;
        int n = hs.size();
        int[][] dp = new int[m+1][n+1];

        for ( int i =1 ; i <= m; i++) {
            for ( int j =1 ; j <= n; j++) {
                if (nums[i-1] == increasedArray[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
        
    }
}
