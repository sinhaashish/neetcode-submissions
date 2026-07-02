class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p) {
        if (memo[i][j] != null) return memo[i][j];
        if (j == p.length()) return memo[i][j] = (i == s.length());
        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j)
                 || p.charAt(j) == '.');

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            memo[i][j] = dfs(i, j + 2, s, p) || (firstMatch && dfs(i + 1, j, s, p));
        } else {
            memo[i][j] = firstMatch && dfs(i + 1, j + 1, s, p);
        }
        return memo[i][j];
    }
}