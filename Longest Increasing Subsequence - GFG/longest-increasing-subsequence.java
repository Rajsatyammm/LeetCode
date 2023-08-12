//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends

// class Solution {
//     //Function to find length of longest increasing subsequence.
//     static int longestSubsequence(int size, int a[]) {
//         // code here
//         return lis(a, size);
        
//     }
    
//     static int lis(int[] a, int n) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int num : a) {
//             set.add(num);
//         }
        
//         int[] arr = new int[set.size()];
//         int idx = 0;
//         for(int num : set) {
//             arr[idx] = num;
//             idx++;
//         }
        
//         Arrays.sort(arr);
//         return lcs(a, arr);
//     }
    
//     static int lcs(int[] a, int[] arr) {
//         int n = a.length;
//         int m = arr.length;
        
//         int[][] dp = new int[n+1][m+1];
//         for(int i=1; i<=n; i++) {
//             for(int j=1; j<=m; j++) {
//                 if(i == 0) dp[i][0] = 0;
//                 if(j == 0) dp[0][j] = 0;
                
//                 int v = a[i-1];
//                 int w = arr[j-1];
//                 if(v == w) {
//                     dp[i][j] = dp[i-1][j-1] + 1;
//                 }
//                 else {
//                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// } 


class Solution {
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[]) {
        // code here
        if(size==0)  return 0;
        
       /* int[] dp=new int[size];
        dp[0]=1;
        int maxLength=1;
        for(int i=1;i<size;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(a[i]>a[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;*/
        List<Integer> piles = new ArrayList<>();
        piles.add(a[0]);

        for (int i = 1; i < size; i++) {
            if (a[i] > piles.get(piles.size() - 1)) {
                piles.add(a[i]);
            } else {
                
                int index = Collections.binarySearch(piles, a[i]);
                if (index < 0) {
                    index = -index - 1;
                }
                piles.set(index, a[i]);
            }
        }

        return piles.size();
    }
}