//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //code here
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(i, vis, st, adj);
            }
        }
        
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0; i<V; i++) adjT.add(new ArrayList<>());
        
        for(int i=0; i<V; i++) {
            vis[i] = false; // for reusing in new dfs traversal
            for(int ne : adj.get(i)) {
                adjT.get(ne).add(i);
            }
        }
        
        // traverse 
        int cnt_scc = 0; // strongly connect component count
        while(!st.isEmpty()) {
            int node = st.pop();
            if(!vis[node]) {
                cnt_scc++;
                dfs_scc(node, vis, adjT);
            }
        }
        
        return cnt_scc;
        
    }
    
    void dfs_scc(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        for(int ne : adj.get(src)) {
            if(!vis[ne]) dfs_scc(ne, vis, adj);
        }
    }
    
    void dfs(int src, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        
        for(int ne : adj.get(src)) {
            if(!vis[ne]) {
                dfs(ne, vis, st, adj);
            }
        }
        
        st.push(src);
    }
}
