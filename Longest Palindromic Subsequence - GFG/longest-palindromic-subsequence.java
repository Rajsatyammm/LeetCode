//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public int lcs(String s, String t) {
        int N = s.length();
        int[][] dp = new int[N+1][N+1];
        
        for(int i=0; i<N; i++) {
            dp[i][0] = 0;
        }
        
        for(int j=0; j<N; j++) {
            dp[0][j] = 0;
        }
        
        // fill bottom to up
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]  + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[N][N];
    }
    
    public int longestPalinSubseq(String S) {
        //code here
        StringBuilder sb = new StringBuilder(S);
        String t = sb.reverse().toString();
        return lcs(S, t);
    }
}