//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[]) {
        // code here
        int sum = 0;
        for(int i : arr) {
            sum += i;
        }
        
        if(sum % 2 != 0) return 0;
        int[][] dp = new int[N+1][sum+1];
        for(int[] a : dp) Arrays.fill(a, -1);
        
        boolean ans = f(0, sum / 2, arr, dp);
        if(ans) return 1;
        return 0;
    }
    
    static boolean f(int i, int sum, int[] arr, int[][] dp) {
        if(i == arr.length) {
            if(sum == 0) return true;
            return false;
        }
        if(dp[i][sum] != -1) 
            return dp[i][sum] == 1 ? true : false;
        boolean notTake = f(i+1, sum, arr, dp);
        boolean take = false;
        if(arr[i] <= sum) {
            take = f(i+1, sum-arr[i], arr, dp);
            sum += arr[i];
        }
        
        boolean ans = take || notTake;
        dp[i][sum] = ans == true ? 1 : 0;
        return ans;
    }
}