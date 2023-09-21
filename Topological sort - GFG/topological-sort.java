//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution {
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        return bfs(0, V, vis, adj);
    }
    
    static int[] bfs(int src, int V, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        // calculate indeg
        Queue<Integer> q = new LinkedList<>(); 
        int[] indeg = new int[V];
        for(int i=0; i<V; i++) {
            for(int ne : adj.get(i)) {
                indeg[ne]++;
            }
        }
        
        for(int i=0; i<V; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }
        
        int[] ans = new int[V];
        int ansIdx = 0;
        
        while(!q.isEmpty()) {
            int curr = q.remove();
            ans[ansIdx++] = curr;
            if(!vis[curr]) {
                vis[curr] = true;
                
                for(int ne : adj.get(curr)) {
                    indeg[ne]--;
                    
                    if(indeg[ne] == 0) {
                        q.add(ne);
                    }
                }
            }
        }
        return ans;
        
    }
    
}

// class Solution {
//     //Function to return list containing vertices in Topological order. 
//     static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
//         // add your code here
//         boolean[] vis = new boolean[V];
//         Stack<Integer> s = new Stack<>();
        
//         for(int i=0; i<V; i++) {
//             if(!vis[i]) {
//                 dfs(i, vis, s, adj);
//             }
//         }
        
//         int[] res = new int[V];
//         int i = 0;
//         while(!s.isEmpty()) {
//             res[i++] = s.pop();
//         }
//         return res;
//     }
    
//     static void dfs(int src, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
//         vis[src] = true;
        
//         for(int ne : adj.get(src)) {
//             if(!vis[ne]) {
//                 dfs(ne, vis, st, adj);
//             }
//         }
        
//         st.push(src);
//     }
// }
