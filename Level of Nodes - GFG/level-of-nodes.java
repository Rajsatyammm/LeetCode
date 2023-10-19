//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    
    static class Pair {
        int node;
        int level;
        
        Pair(int n, int l) {
            node = n;
            level = l;
        }
    }
    
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        // code here
        boolean[] vis = new boolean[V];
        int src = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int level = p.level;
            
            if(node == X) return level;
            
            if(!vis[node]) {
                vis[node] = true;
                
                for(int ne : adj.get(node)) {
                    q.add(new Pair(ne, level + 1));
                }
            }
        }
        
        return -1;
    }
}