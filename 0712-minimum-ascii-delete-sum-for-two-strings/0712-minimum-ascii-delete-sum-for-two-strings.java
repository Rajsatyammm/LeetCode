class Solution {
    public int minimumDeleteSum(String word1, String word2) {
        int n = word1.length() + 1;
        int m = word2.length() + 1;
        char[] schar1 = word1.toCharArray();
        char[] schar2 = word2.toCharArray();

        int dp[][] = new int[n][m];

        for(int j=1; j<m; j++) {
             dp[0][j] = dp[0][j-1] + (int)schar2[j-1] ;
        }

        for(int i=1; i<n; i++) {
             dp[i][0] = dp[i-1][0] + (int)schar1[i-1] ;
        }

        for(int i=1; i<n; i++) {
            for(int j=1;j<m; j++) {
                if(schar1[i-1] == schar2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int x = dp[i-1][j] + (int)schar1[i-1];
                    int y = dp[i][j-1] + (int)schar2[j-1];
                    dp[i][j] = Math.min(x, y);
                }
            }
        }

        return dp[n-1][m-1];
	}
}