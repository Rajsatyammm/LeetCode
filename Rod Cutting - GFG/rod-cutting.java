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
    private int cut(int[] price, int n) {
        int N = price.length;
        int[][] dp = new int[N + 1][n+1];
        for(int i=0; i<N; i++) {
            dp[i][0] = 0;
        }
        for(int j=0; j<n; j++) {
            dp[0][n] = 0;
        }
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=n; j++) {
                int cut = i;
                int cost = price[i-1];
                
                if(cut <= j) {
                    dp[i][j] = Math.max(cost + dp[i][j-cut], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][n];
    }
    
    public int cutRod(int price[], int n) {
        //code here
        return cut(price, n);
    }
}