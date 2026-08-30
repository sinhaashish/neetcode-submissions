class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
           for (int i = 0; i <= m; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }

        for (int j = 0; j <= n; j++) {
            dp[m][j] = Integer.MAX_VALUE;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) { continue; }
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
        
    }
}