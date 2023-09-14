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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int mod = 1000000007;
    
	public int perfectSum(int arr[], int n, int sum) { 
	    // Your code goes here
	    int[][] dp = new int[n+1][sum+1];
	    for(int[] a : dp) Arrays.fill(a, -1);
	    return f(0, n, sum, arr, dp);
	    
	} 
	
	int f(int i, int n, int tar, int[] arr, int[][] dp) {
	    if(i == n) {
	        if(tar == 0) return 1;
	        return 0;
	    }
	    if(dp[i][tar] != -1) return dp[i][tar];
	    
	    int pick = 0;
	    if(tar >= arr[i])
	        pick = f(i+1, n, tar-arr[i], arr, dp) % mod;
	    int notPick = f(i+1, n, tar, arr, dp) % mod;
	    return dp[i][tar] = (pick + notPick) % mod;
	}
}