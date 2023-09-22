//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        List<List<Integer>> revAdj = new ArrayList<>();
        
        for(int i=0; i<V; i++) {
            revAdj.add(new ArrayList<>());
        }
        
        int[] indeg = new int[V];
        boolean[] vis = new boolean[V];
        
        // reverse logic of graph
        for(int i=0; i<V; i++) {
            for(int ne : adj.get(i)) {
                revAdj.get(ne).add(i);
                indeg[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++) {
            if(indeg[i] == 0) q.add(i);
        }
        
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int curr = q.remove();
            
            if(!vis[curr]) {
                vis[curr] = true;
                res.add(curr);
                
                for(int ne : revAdj.get(curr)) {
                    indeg[ne]--;
                    
                    if(indeg[ne] == 0) q.add(ne);
                }
            }
        }
        
        Collections.sort(res);
        return res;
        
    }
}
