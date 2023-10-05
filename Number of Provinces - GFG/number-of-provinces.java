//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    static class DisjointSet {
        public int[] par;
        private int[] rank;
        
        DisjointSet(int n) {
            par = new int[n+1];
            rank = new int[n+1];
            for(int i=0; i<=n; i++) {
                par[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int n) {
            if(n == par[n]) return n;
            return par[n] = find(par[n]);
        }
        
        public void union(int a, int b) {
            int parA = find(a);
            int parB = find(b);
            if(parA == parB) return;
            if(rank[parA] > rank[parB]) {
                par[parB] = parA;
            }
            else if(rank[a] < rank[b]) {
                par[parA] = parB;
            }
            else {
                par[parA] = parB;
                rank[parB]++;
            }
        }
    }
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        // ArrayList<ArrayList<Integer>> adj = edges;
        DisjointSet ds = new DisjointSet(V);
        for(int i=0; i<V; i++) {
            for(int j=0; j<V; j++) {
                if(adj.get(i).get(j) == 1) {
                    ds.union(i, j);
                }
            }
        }
        
        int cnt = 0;
        for(int i=0; i<V; i++) {
            if(ds.par[i] == i) cnt++;
        }
        return cnt;
    }
};