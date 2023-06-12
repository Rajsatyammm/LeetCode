//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp = new int[n+1][n+1];
        // initialisation
        for(int i=0; i<n; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<n; j++) {
            dp[0][j] = 0;
        }
        
        // filling the dp array
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                int len = i;
                int val = price[i-1];
                
                if(len <= j) {
                    dp[i][j] = Math.max(val + dp[i][j-len], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }
}