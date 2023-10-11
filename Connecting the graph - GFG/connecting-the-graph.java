//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    class DisjointSet {
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

    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds = new DisjointSet(n);
        int extraEdge = 0;
        for(int[] arr : edge) {
            int u = arr[0];
            int v = arr[1];
            if(ds.find(u) == ds.find(v)) {
                extraEdge++;
            }
            else {
                ds.union(u, v);
            }
        }
        
        int diffComp = 0;
        for(int i=0; i<n; i++) {
            if(ds.par[i] == i) diffComp++;
        }
        
        int minEdgeNeeded = diffComp - 1;
        if(extraEdge >= minEdgeNeeded) return minEdgeNeeded;
        return -1;
    }
}