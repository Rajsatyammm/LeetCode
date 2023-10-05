//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    
    static class DisjointSet {
        private int[] par;
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
    
    static class Trio implements Comparable<Trio> {
        int wt;
        int src;
        int dest;
        
        Trio(int w, int s, int d) {
            wt = w;
            src = s;
            dest = d;
        }
        
        public int compareTo(Trio t) {
            if(this.wt == t.wt) {
                return this.src - t.src;
            }
            return this.wt - t.wt;
        }
    }
    
    static int spanningTree(int V, int E, int edges[][]) {
	    // Code Here. 
	   DisjointSet ds = new DisjointSet(V);
	   int minWt = 0;
	    PriorityQueue<Trio> pq = new PriorityQueue<>();
	    for(int[] arr : edges)
	        pq.add(new Trio(arr[2], arr[0], arr[1]));
	    
	    while(!pq.isEmpty()) {
	        Trio t = pq.poll();
	        if(ds.find(t.src) != ds.find(t.dest)) {
	            minWt += t.wt;
	            ds.union(t.src, t.dest);
	        }
	    }
	    
	    return minWt;
	}
}