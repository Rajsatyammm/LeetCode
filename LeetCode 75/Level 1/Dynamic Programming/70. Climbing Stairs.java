// 70. Climbing Stairs

class Solution {
    private int climb(int n, int[] dp) {

        //memoisation
        if(n==0) return 1;
        if(n==1) return 1;
        if(dp[n] != 0) {
            return dp[n];
        } 
        dp[n] = climb(n-1, dp) + climb(n-2, dp);
        return dp[n];

        //tabulation
        // if(n == 0 || n == 1) {
        //     return 1;
        // }

        // for(int i=2; i<=n; i++) {
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];

    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        // // for tabulation
        // dp[0] = 1;
        // dp[1] = 1;
        return climb(n, dp);
    }
}
