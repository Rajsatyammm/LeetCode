//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    static long mod = 1000000007;
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n) {
        // add your code here
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return f(0, n, dp);
    }
    
    static long f(int i, int n, long[] dp) {
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != -1) return dp[i];
        long one = f(i+1, n, dp) % mod;
        long two = f(i+2, n, dp) % mod;
        long three = f(i+3, n, dp) % mod;
        return dp[i] = ((one + two + three) % mod);
    }
}

