// Space Optimaization

class Solution {
    public int maxProfit(int k, int[] prices) {
        return f(2*k, prices);
    }

    int f(int k, int[] price) {
        int n = price.length;
        int[] prev = new int[k+1];
        int[] curr = new int[k+1];
        for(int i=0; i<=n; i++) prev[0] = 0;
        for(int j=0; j<=k; j++) prev[j] = 0;
        
        for(int i=n-1; i>=0; i--) {
            for(int maxTr=1; maxTr<=k; maxTr++) {
                if(maxTr % 2 == 0) { //buy case
                    curr[maxTr] = Math.max(-price[i] + prev[maxTr-1], prev[maxTr]);
                }
                else { // sell case
                    curr[maxTr] = Math.max(price[i] + prev[maxTr-1], prev[maxTr]);
                }
            }
            prev = curr;
        }
        return prev[k];
    }
}



// Memoisation 2D DP

// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n+1][2*k+1];
//         for(int[] a : dp) Arrays.fill(a, -1);
//         return f(0, 2*k, prices, dp);
//     }

//     int f(int i, int maxTr, int[] price, int[][] dp) {
//         if(i == price.length || maxTr == 0) return 0;
//         if(dp[i][maxTr] != -1) return dp[i][maxTr];
//         if(maxTr % 2 == 0) { //buy case
//             return dp[i][maxTr] =  Math.max(-price[i] + f(i+1, maxTr-1, price, dp), f(i+1, maxTr, price, dp));
//         }
//         else { // sell case
//             return dp[i][maxTr] = Math.max(price[i] + f(i+1, maxTr-1, price, dp), f(i+1, maxTr, price, dp));
//         }
//     }
// }


// Tabulation 2D DP

// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         return f(2*k, prices);
//     }
    
//     int f(int k, int[] price) {
//         int n = price.length;
//         int[][] dp = new int[n+1][k+1];
//         for(int i=0; i<=n; i++) dp[i][0] = 0;
//         for(int j=0; j<=k; j++) dp[0][j] = 0;
        
//         for(int i=n-1; i>=0; i--) {
//             for(int maxTr=1; maxTr<=k; maxTr++) {
//                 if(maxTr % 2 == 0) { //buy case
//                     dp[i][maxTr] = Math.max(-price[i] + dp[i+1][maxTr-1], dp[i+1][maxTr]);
//                 }
//                 else { // sell case
//                     dp[i][maxTr] = Math.max(price[i] + dp[i+1][maxTr-1], dp[i+1][maxTr]);
//                 }
//             }
//         }
//         return dp[0][k];
//     }
// }

// Tabulation 3D DP

// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         return f(prices);
//     }
    
//     int f(int[] price) {
//         int n = price.length;
//         int[][][] dp = new int[n+1][2][3];
//         for(int j=0; j<2; j++) {
//             for(int k=0; k<3; k++) {
//                 dp[0][j][k] = 0;
//             }
//         }
        
//         for(int i=0; i<=n; i++) {
//             for(int j=0; j<2; j++) {
//                 dp[i][j][0] = 0;
//             }
//         }
        
        
//         for(int i=n-1; i>=0; i--) {
//             for(int buy=0; buy<=1; buy++) {
//                 for(int max=1; max<=2; max++) {
//                     if(buy == 1) // buy
//                         dp[i][buy][max] = Math.max(-price[i] + dp[i+1][0][max], dp[i+1][1][max]);
                    
//                     else //sell
//                         dp[i][buy][max] = Math.max(price[i] + dp[i+1][1][max-1], dp[i+1][0][max]);
//                 }
//             }
//         }
        
//         return dp[0][1][2];   
//     }
// }

// Memoisation 3D DP

// class Solution {
//     public int maxProfit(int k, int[] prices) {
//         int n = prices.length;
//         int[][][] dp = new int[n+1][3][k+1];
//         for(int[][] arr : dp) {
//             for(int[] a : arr) Arrays.fill(a, -1);
//         }
//         return f(0, 1, k, prices, dp);
//     }  
    
//     int f(int i, int buy, int max, int[] price, int[][][] dp) {
//         if(i == price.length) return 0;
//         if(max == 0) return 0;
//         if(dp[i][buy][max] != -1) return dp[i][buy][max];
//         //buy
//         if(buy == 1) 
//             return dp[i][buy][max] = Math.max(-price[i] + f(i+1, 0, max, price, dp), f(i+1, 1, max, price, dp));
//         //sell
//         else 
//             return dp[i][buy][max] = Math.max(price[i] + f(i+1, 1, max-1, price, dp), f(i+1, 0, max, price, dp));
//     }
// }