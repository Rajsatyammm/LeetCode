//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        // Code here
        int[] col = new int[V];
        Arrays.fill(col, -1);
        for(int i=0; i<V; i++) {
            if(col[i] == -1) {
                if(!dfs(i, 0, col, adj)) return false;
            }
        }
        return true;
    }
    
    boolean dfs(int src, int color, int[] col, ArrayList<ArrayList<Integer>>adj) {
        col[src] = color;
        
        for(int ne : adj.get(src)) {
            if(col[ne] == -1) {
                int newCol = color == 1 ? 0 : 1;
                if(!dfs(ne, newCol, col, adj)) return false;
            }
            else if(col[ne] == color) {
                return false;
            }
        }
        return true;
    }
    
    boolean bfs(int src, int[] col, ArrayList<ArrayList<Integer>>adj) {
        Queue<Integer> q = new LinkedList<>();
        col[src] = 0;
        q.add(src);
        
        while(!q.isEmpty()) {
            int curr = q.remove();
            
            for(int ne : adj.get(curr)) {
                if(col[ne] == -1) {
                    int nextCol = col[curr] == 0 ? 1 : 0;
                    col[ne] = nextCol;
                    q.add(ne);
                }
                else if(col[curr] == col[ne]) {
                    return false;
                }
            }
        }
        return true;
    }
}