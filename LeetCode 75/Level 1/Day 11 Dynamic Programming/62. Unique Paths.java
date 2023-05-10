// 62. Unique Paths

class Solution {
    private int paths(int[][] dp, int i, int j, int m, int n) {
        if(i == m-1 && j == n-1) {
            return 1;
        }
        if(i >= m || j >= n) {
            return 0;
        }
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = paths(dp, i+1, j, m, n) + paths(dp, i, j+1, m, n);
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return paths(dp, 0, 0, m, n);
    }
}
