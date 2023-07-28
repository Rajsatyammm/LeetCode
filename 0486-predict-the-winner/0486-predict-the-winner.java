class Solution {
    public int solve(int[][] dp,int []v,int i,int j,int k){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int first=0, last=0, ans=0;
        if(k % 2 == 0){
            first = v[i] + solve(dp, v, i+1, j, k+1);
            last = v[j] + solve(dp, v, i, j-1, k+1);
            ans = Math.max(first, last); 
        }
        else {
            first = -v[i] + solve(dp, v, i+1, j, k+1);
            last = -v[j] + solve(dp, v, i, j-1, k+1);
            ans = Math.min(first, last);
        }
        return dp[i][j] = ans;
    }

    public boolean PredictTheWinner(int[] nums) {
        int i, n=nums.length;
        int[][] dp = new int[n][n];
        for(i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return solve(dp, nums, 0, n-1, 0) >= 0;
    }
}