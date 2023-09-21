//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution {
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        // Your code here
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, n-1, arr, dp);
    }
    
    int f(int i, int n, int[] arr, int[] dp) {
        if(i == n) return arr[n];
        if(i > n) return 0;
        if(dp[i] != -1) return dp[i];
        int take = arr[i] + f(i+2, n, arr, dp);
        int notTake = f(i+1, n, arr, dp);
        
        return dp[i] = Math.max(take, notTake);
    }
}