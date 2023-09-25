//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    class Pair {
        int c;
        int par;
        
        Pair(int c, int p) {
            this.c = c;
            par = p;
        }
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                if(bfs(i, vis, adj)) return true;
            }
        }
        return false;
    }
    
    boolean bfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.c;
            int par = p.par;
            
            if(!vis[node]) {
                vis[node] = true;
                
                for(int ne : adj.get(node)) {
                    if(!vis[ne]) {
                        q.add(new Pair(ne, node));
                    }
                    else if(par != -1 && par != ne) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}