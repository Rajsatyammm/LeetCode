//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution {
    public static String kthPermutation(int n, int k) {
        // code here
        
        int fact[] = new int[n+1];
        Arrays.fill(fact, 1);
        for(int i=1; i<=n; i++) fact[i] = i * fact[i-1];
        boolean vis[] = new boolean[n+1];
        // Arrays.fill(vis, false);
        StringBuilder ans = new StringBuilder();
        int i = n;
        while(ans.length() != n){
            int row = k / fact[i-1];
            if(k % fact[i-1] != 0) row++;
            for(int j=1; j<=n; j++){
                if(vis[j] == false){
                    row--;
                }
                if(row == 0){
                    vis[j] = true;
                    char a = (char)(j+'0');
                    ans.append(a);
                    break;
                }
            }
            k = k % fact[i-1];
            if(k == 0) k = fact[i-1];
            i--;
        }
        return ans.toString();
    }
}
        


//{ Driver Code Starts.

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
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends