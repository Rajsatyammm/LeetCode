//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends






class Solution {
    public static int findCatalan(int n) {
        // code here
        int c[] = new int[n+1];
        c[0] = c[1] = 1;
        long mod = 1000_000_007L;
        for(int i=2; i<=n; i++) {
            long ans=0;
            //c[i]=0;
            for(int j=0; j<i; j++) {
                ans=(ans + ((long) c[j] * c[i - j - 1]) % mod) % mod;
            }
            c[i] =(int) ans;
           
        }
        return c[n];
    }
}
        
        
