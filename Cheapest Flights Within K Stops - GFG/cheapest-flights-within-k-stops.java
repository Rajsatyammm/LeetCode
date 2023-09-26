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
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    class Trio {
        int dest;
        int price;
        int stops;
        
        Trio(int s, int d, int p) {
            dest = d;
            price = p;
            stops = s;
        }
    }
    
    class Pair {
        int dest;
        int wt;
        
        Pair(int d, int w) {
            dest = d;
            wt = w;
        }
    }
    
    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        
        for(int[] arr : flights) {
            adj.get(arr[0]).add(new Pair(arr[1], arr[2]));
        }
        
        Queue<Trio> pq = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;
        pq.add(new Trio(0, src, 0));
        
        while(!pq.isEmpty()) {
            Trio t = pq.poll();
            int node = t.dest;
            int price = t.price;
            int stops = t.stops;
            
            if(stops > k) continue;
            
            for(Pair neig : adj.get(node)) {
                int adjNode = neig.dest;
                int edgeWt = neig.wt;
                
                if(price + edgeWt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = price + edgeWt;
                    pq.add(new Trio(stops+1, adjNode, dist[adjNode]));
                }
            }
            
        }
        
        if(dist[dst] == (int)(1e9)) {
            return -1;
        }
        return dist[dst];
    }
}