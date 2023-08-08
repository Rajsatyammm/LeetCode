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
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    
    public static int countFractions(int n, int[] num, int[] denom) {
        int ans=0;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int x = num[i], y = denom[i];
            int g = gcd(x, y);
            x /= g;  y /= g;
           
            int n_x = y-x; int n_y=y;
            if(map.containsKey(n_x) && map.get(n_x).containsKey(y)){
                ans += map.get(n_x).get(y);
            }
            if(map.containsKey(x)) {
                HashMap<Integer,Integer> hm = map.get(x);
                hm.put(y, hm.getOrDefault(y, 0) + 1);
            }
            else {
                HashMap<Integer, Integer> hm = new HashMap<>();
                hm.put(y, 1);
                map.put(x, hm);
            }
        }
        return ans;
    }
    
    static int gcd(int a,int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
        
