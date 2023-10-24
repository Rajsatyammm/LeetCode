//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        int n = str.length();

        // dp[i][j] will be 'true' if the string from index i to j is a palindrome.
        boolean[][] dp = new boolean[n][n];
        
        // To handle single characters, they are palindrome by default.
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Loop through the string and check for palindrome substrings.
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (len == 2) {
                    dp[i][j] = (str.charAt(i) == str.charAt(j));
                } else {
                    dp[i][j] = (str.charAt(i) == str.charAt(j)) && dp[i+1][j-1];
                }
            }
        }

        // minCuts[i] will store the minimum cuts needed for substring str[0...i].
        int[] minCuts = new int[n];
        for (int i = 0; i < n; i++) {
            int minCut = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (dp[j][i]) {
                    minCut = (j == 0) ? 0 : Math.min(minCut, 1 + minCuts[j-1]);
                }
            }
            minCuts[i] = minCut;
        }

        return minCuts[n-1];
    }
}