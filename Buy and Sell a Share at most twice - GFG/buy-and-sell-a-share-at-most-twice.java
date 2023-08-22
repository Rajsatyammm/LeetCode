//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        // code here
        // int[][][] dp = new int[n][3][3];
        // for(int[][] arr : dp) {
        //     for(int[] a : arr) Arrays.fill(a, -1);
        // }
        return f(price);
    }
    
    
    // Space Optimization
    static int f(int[] price) {
        int n = price.length;
        int[] prev = new int[5];
        int[] curr = new int[5];
        for(int i=0; i<=n; i++) prev[0] = 0;
        for(int j=0; j<5; j++) prev[j] = 0;
        
        for(int i=n-1; i>=0; i--) {
            for(int maxTr=1; maxTr<5; maxTr++) {
                if(maxTr % 2 == 0) { //buy case
                    curr[maxTr] = Math.max(-price[i] + prev[maxTr-1], prev[maxTr]);
                }
                else { // sell case
                    curr[maxTr] = Math.max(price[i] + prev[maxTr-1], prev[maxTr]);
                }
            }
            prev = curr;
        }
        return prev[4];
    }
    
    
    // Recursion 
    
    // static int f(int i, int maxTr, int[] price) {
    //     if(i == price.length || maxTr == 0) return 0;
        
    //     if(maxTr % 2 == 0) { //buy case
    //         return Math.max(-price[i] + f(i+1, maxTr-1, price), f(i+1, maxTr, price));
    //     }
    //     else { // sell case
    //         return Math.max(price[i] + f(i+1, maxTr-1, price), f(i+1, maxTr, price));
    //     }
    // }
    
    
    // Tabulation 2D DP
    
    // static int f(int[] price) {
    //     int n = price.length;
    //     int[][] dp = new int[n+1][5];
    //     for(int i=0; i<=n; i++) dp[i][0] = 0;
    //     for(int j=0; j<5; j++) dp[0][j] = 0;
        
    //     for(int i=n-1; i>=0; i--) {
    //         for(int maxTr=1; maxTr<5; maxTr++) {
    //             if(maxTr % 2 == 0) { //buy case
    //                 dp[i][maxTr] = Math.max(-price[i] + dp[i+1][maxTr-1], dp[i+1][maxTr]);
    //             }
    //             else { // sell case
    //                 dp[i][maxTr] = Math.max(price[i] + dp[i+1][maxTr-1], dp[i+1][maxTr]);
    //             }
    //         }
    //     }
    //     return dp[0][4];
    // }
    
    // Memoisation 3D DP
    
    // static int f(int i, int buy, int max, int[] price, int[][][] dp) {
    //     if(i == price.length) return 0;
    //     if(max == 0) return 0;
    //     if(dp[i][buy][max] != -1) return dp[i][buy][max];
    //     //buy
    //     if(buy == 1) 
    //         return dp[i][buy][max] = Math.max(-price[i] + f(i+1, 0, max, price, dp), f(i+1, 1, max, price, dp));
    //     //sell
    //     else 
    //         return dp[i][buy][max] = Math.max(price[i] + f(i+1, 1, max-1, price, dp), f(i+1, 0, max, price, dp));
    // }
    
    
    // Tabulation 3D DP
    
    // static int f(int[] price) {
    //     int n = price.length;
    //     int[][][] dp = new int[n+1][2][3];
    //     for(int j=0; j<2; j++) {
    //         for(int k=0; k<3; k++) {
    //             dp[0][j][k] = 0;
    //         }
    //     }
        
    //     for(int i=0; i<=n; i++) {
    //         for(int j=0; j<2; j++) {
    //             dp[i][j][0] = 0;
    //         }
    //     }
        
        
    //     for(int i=n-1; i>=0; i--) {
    //         for(int buy=0; buy<=1; buy++) {
    //             for(int max=1; max<=2; max++) {
    //                 if(buy == 1) 
    //                     dp[i][buy][max] = Math.max(-price[i] + dp[i+1][0][max], dp[i+1][1][max]);
    //                 //sell
    //                 else 
    //                     dp[i][buy][max] = Math.max(price[i] + dp[i+1][1][max-1], dp[i+1][0][max]);
    //             }
    //         }
    //     }
        
    //     return dp[0][1][2];
        
    // }
    
    
}
        
