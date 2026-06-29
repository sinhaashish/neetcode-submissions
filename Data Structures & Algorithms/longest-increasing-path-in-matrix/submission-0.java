class Solution {
    private int[][] matrix; private int[][] dp; private int rows, cols;
    private final int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix; rows = matrix.length; cols = matrix[0].length;
        dp = new int[rows][cols]; int ans = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                ans = Math.max(ans, dfs(r, c));
            }
        }
        return ans;
    }
    private int dfs(int r, int c) {
        if (dp[r][c] != 0) return dp[r][c];
        int longest = 1;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                continue;
            if (matrix[nr][nc] <= matrix[r][c])
                continue;
            longest = Math.max( longest, 1 + dfs(nr, nc));
        }
        dp[r][c] = longest;
        return longest;
    }
}