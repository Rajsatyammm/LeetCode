//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair {
    int dest, w;
    Pair(int dest, int w) {
        this.dest = dest;
        this.w = w;
    }
}

class Solution {
	public int[] shortestPath(int N,int M, int[][] edges) {
    	int[] distance = new int[N];
    	boolean[] visited = new boolean[N];
    	Stack<Integer> st = new Stack<>();
    	Arrays.fill(distance, Integer.MAX_VALUE);
    	distance[0] = 0;
    	
    	ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    	// Initialize the adjacency list
    	
        for(int i = 0; i < N; i++) adj.add(new ArrayList<>());
    	//Storing into adjaceny adj
        for(int i = 0; i < M; i++){
            int u = edges[i][0];
            int dest = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(dest, w));
        }
        
        //Find the topological sort for given edges
        for(int i = 0; i < N; i++){
            if(!visited[i]) topologicalSort(adj, visited, st, i);
        }
        
    	while(!st.isEmpty()){
    	     int u = st.pop();
    	     //For every adjacent v of u, find min. of distance[v] and distance[u] + weight(u, v)
    	     for(int v = 0; v < adj.get(u).size(); v++){
    	         int dest = adj.get(u).get(v).dest;
    	         int w = adj.get(u).get(v).w;
    	         if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[dest]) distance[dest] = distance[u] + w;
    	     }
    	}
        // Replace unreachable nodes with -1
            for (int i = 0; i < N; i++) {
                if (distance[i] == Integer.MAX_VALUE) distance[i] = -1;
            }
            return distance;
    	}
    	
    	public void topologicalSort(ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> st, int u){
        	visited[u] = true;
            for(int v = 0; v < adj.get(u).size(); v++){
                if(!visited[adj.get(u).get(v).dest]) topologicalSort(adj, visited, st, adj.get(u).get(v).dest);
            }
            st.push(u);
    } 
}