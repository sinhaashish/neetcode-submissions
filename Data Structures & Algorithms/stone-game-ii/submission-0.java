
class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        // suffix[i] = total stones from pile i to the end
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n + 1];
        return solve(piles, 0, 1, suffix, dp);
    }

    private int solve(int[] piles, int i, int M, int[] suffix, int[][] dp) {
        int n = piles.length;
        // No piles left
        if (i >= n) {
            return 0;
        }
        // Current player can take all remaining piles
        if (i + 2 * M >= n) {
            return suffix[i];
        }
        // Return previously calculated answer
        if (dp[i][M] != 0) {
            return dp[i][M];
        }
        int maxStones = 0;
        // Try taking X piles, where 1 <= X <= 2 * M
        for (int X = 1; X <= 2 * M; X++) {
            int remainingStones = suffix[i];
            int opponentStones = solve(piles, i + X, Math.max(M, X), suffix, dp);
            // Current player's stones = remaining - opponent's stones
            int currentStones = remainingStones - opponentStones;
            maxStones = Math.max(maxStones, currentStones);
        }
        dp[i][M] = maxStones;
        return maxStones;
    }
}
