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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;
        q.add(src);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int ne : adj.get(curr)) {
                if(dist[curr] + 1 < dist[ne]) {
                    dist[ne] = dist[curr] + 1;
                    q.add(ne);
                }
            }
        }
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        for(int i=0; i<n; i++) {
            if(dist[i] != (int)(1e9)) {
                res[i] = dist[i];
            }
        }
        
        return res;
    }
}