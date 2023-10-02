//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    final int MOD = (int)1e9 + 7;

    int distinctSubsequences(String s) {
        // Get the length of the string
        int n = s.length();

        int[] dp = new int[n + 1];
        int[] last_occurrence = new int[256];
        Arrays.fill(last_occurrence, -1);

        // Base case: there's only one subsequence (the empty string)
        dp[0] = 1;

        // Iterate over each character in the string
        for (int i = 1; i <= n; i++) {
            // For each character, we have two options: include it in our subsequences or not
            dp[i] = (2 * dp[i - 1]) % MOD;

            // If the current character has appeared before, subtract the number of subsequences at its last occurrence
            if (last_occurrence[s.charAt(i - 1)] != -1) {
                dp[i] -= dp[last_occurrence[s.charAt(i - 1)]];
            }

            // Take modulo to avoid overflow
            dp[i] %= MOD;

            // Update the last occurrence of the current character
            last_occurrence[s.charAt(i - 1)] = i - 1;
        }

        // Return the number of distinct subsequences modulo MOD
        return (dp[n] + MOD) % MOD;
    }
}