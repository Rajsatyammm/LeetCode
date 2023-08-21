class Solution {
    public int numDistinct(String s, String t) {
        return helper(s, t);
    }

    private int helper(String s, String t) {
        int n = s.length();
        int m = t.length();
         
        int[] dp = new int[m+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++) {
            for(int j=m; j>=1; j--) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }
        return dp[m];
    }
}