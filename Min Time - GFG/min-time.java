//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG implements Runnable{
    
	public static void main (String[] args) throws Exception{
        new Thread(null, new GFG(), "whatever", 1<<26).start();
    }
    public void run()
    {
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
                
            int t=Integer.parseInt(in.readLine());
            while(t-- > 0){
                int n=Integer.parseInt(in.readLine().trim());
                int A[]=new int[n],B[]=new int[n];
                String s[]=in.readLine().trim().split(" ");
                for(int i=0;i<n;i++){
                    A[i]=Integer.parseInt(s[i]);
                }
                s=in.readLine().trim().split(" ");
                for(int i=0;i<n;i++){
                    B[i]=Integer.parseInt(s[i]);
                }
                Solution ob=new Solution();
                long ans=ob.minTime(n,A,B);
                out.println(ans);
            }
            out.close();
        }catch(IOException e){
            ;
        }
    }
}
// } Driver Code Ends

class Solution {
    
    static Map<Integer,Integer> map1;
    static Map<Integer,Integer> map2;
    static List<Integer> temp;
    static long help(int pos, int index, long dp[][], int indication) {
        
        if(index == temp.size()) return 0;
        if(dp[index][indication] != -1) return dp[index][indication];
        int left = map1.get(temp.get(index));
        int right = map2.get(temp.get(index));
        long one=0, two=0;
        one = Math.abs(pos-left) + Math.abs(left-right) + help(right, index+1, dp, 1);
        if(index==temp.size()-1) one += Math.abs(right-0);
        two = Math.abs(pos-right) + Math.abs(right-left) + help(left, index+1, dp, 0);
        if(index==temp.size()-1) two += Math.abs(left-0);
        return dp[index][indication] = Math.min(one, two);
    }
    
    public static long minTime(int n, int[] locations, int[] types) {
        // code here
        temp = new ArrayList<>();
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        int mx = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) mx = Math.max(mx, types[i]);
        int ele[] = new int[mx+1];
        
        Arrays.fill(ele, 0);
        
        for(int i=0; i<n; i++) {
            if(map1.get(types[i]) == null) {
                ele[types[i]] = 1;
                map1.put(types[i], locations[i]);
                map2.put(types[i], locations[i]);
            }
            else{
                map1.put(types[i], Math.min(map1.get(types[i]), locations[i]));
                map2.put(types[i], Math.max(map2.get(types[i]), locations[i]));
            }
        }
        for(int i=0; i<=mx; i++) {
            if(ele[i] == 1) temp.add(i);
        } 
        int a = temp.size();
        long dp[][] = new long[a][2];
        for(long t[] : dp) {
            Arrays.fill(t,-1);
        }
        return help(0, 0, dp, 0);
    }
}
        
