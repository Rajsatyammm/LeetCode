class Solution {
    static int min = Integer.MAX_VALUE;
    private int minPath(int[][] grid, int i, int j, int n, int m, int[][] dp) {
        if(i == 0 && j == 0) return grid[i][j];
        if(i < 0 || j < 0) return 1000000009;
        
        if(dp[i][j] != -1) return dp[i][j];
        int right = minPath(grid, i, j-1, n, m, dp);
        int bottom = minPath(grid, i-1, j, n, m, dp);
        return dp[i][j] = Math.min(right, bottom) + grid[i][j];
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int[] a : dp) Arrays.fill(a, -1);
        return minPath(grid, n-1, m-1, n, m, dp);
    }
}