
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int reachable = 0;
        for (int i = 1; i < n; i++) {
            // Add index that just entered the valid jump range
            int add = i - minJump;
            if (add >= 0 && dp[add]) {
                reachable++;
            }
            // Remove index that is now outside the valid range
            int remove = i - maxJump - 1;
            if (remove >= 0 && dp[remove]) {
                reachable--;
            }
            // We can reach i if:
            // 1. s[i] is '0'
            // 2. At least one reachable index is in the jump range
            if (s.charAt(i) == '0' && reachable > 0) {
                dp[i] = true;
            }
        }
        return dp[n - 1];
    }
}
