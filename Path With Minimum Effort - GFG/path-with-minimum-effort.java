//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {

    class Trio {
        int effort;
        int i;
        int j;
        
        Trio(int m, int i, int j) {
            this.effort = m;
            this.i = i;
            this.j = j;
        }
    }
    
    int MinimumEffort(int heights[][]) {
        int n = heights.length;
        int m = heights[0].length;
        
        PriorityQueue<Trio> pq = new PriorityQueue<Trio>((x, y) -> x.effort - y.effort);
        int[][] dist = new int[n][m];
        for(int[] arr : dist) {
            Arrays.fill(arr, (int)(1e9));
        }
        
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        pq.add(new Trio(0, 0, 0));
        
        while(!pq.isEmpty()) {
            Trio t = pq.poll();
            
            if(t.i == n-1 && t.j == m-1) {
                return t.effort;
            }
            
            for(int i=0; i<4; i++) {
                int newR = t.i + direction[i][0];
                int newC = t.j + direction[i][1];

                if(newR >= 0 && newR < n && newC >= 0 && newC < m) {
                    int newEffort = Math.max(t.effort, Math.abs(heights[t.i][t.j] - heights[newR][newC]));
                    if(newEffort < dist[newR][newC]) {
                        dist[newR][newC] = newEffort;
                        pq.add(new Trio(newEffort, newR, newC));
                    }
                }
            }
            
        }
        return 0;
    }
}