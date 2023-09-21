//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    ArrayList<String> al = new ArrayList<>();
                    dfs(i, j, i, j, al, vis, set, grid);
                    set.add(al);
                }
            }
        }
        
        return set.size();
    }
    
    void dfs(int row, int col, int row0, int col0, ArrayList<String> al, 
            int[][] vis, HashSet<ArrayList<String>> set, int[][] grid) {
                
            vis[row][col] = 1;
            al.add(toString(row - row0, col - col0));
            
            int n = grid.length;
            int m = grid[0].length;
            
            int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int i=0; i<4; i++) {
                int nRow = row + dist[i][0];
                int nCol = col + dist[i][1];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m 
                    && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0) {
                    dfs(nRow, nCol, row0, col0, al, vis, set, grid);
                }
            }
    }
    
    String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }
}
