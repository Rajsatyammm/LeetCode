//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.is_bleak(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static int countsetbit(int x){
        int count = 0;
        while(x > 0){
            count += x & 1;
            x >>= 1;
        }
        return count;
    }
    
    public int is_bleak(int n) {
        // Code here
        for(int i = Math.max(1, n - 32); i < n; i++){
            if((i+countsetbit(i))==n){
                return 0;
            }
        }
        return 1;
    }
}