//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// class Solution {
    
//     private boolean isValid(char[][] grid, int i, int j, int n, int m) {
//         if(i >=0 && i < n && j >= 0 && j < m && grid[i][j] == '1') 
//             return true;
//         return false;
//     }
    
//     private void dfs(char[][] grid, int i, int j, int n, int m) {
//         grid[i][j] = '0';
        
//         if(isValid(grid, i-1, j, n, m)) dfs(grid, i-1, j, n, m);
//         if(isValid(grid, i-1, j+1, n, m)) dfs(grid, i-1, j+1, n, m);
//         if(isValid(grid, i+1, j, n, m)) dfs(grid, i+1, j, n, m);
//         if(isValid(grid, i+1, j+1, n, m)) dfs(grid, i+1, j+1, n, m);
//         if(isValid(grid, i+1, j, n, m)) dfs(grid, i+1, j, n, m);
//         if(isValid(grid, i+1, j-1, n, m)) dfs(grid, i+1, j-1, n, m);
//         if(isValid(grid, i-1, j, n, m)) dfs(grid, i-1, j, n, m);
//         if(isValid(grid, i-1, j-1, n, m)) dfs(grid, i-1, j-1, n, m);
//     }
    
//     // Function to find the number of islands.
//     public int numIslands(char[][] grid) {
//         // Code here
//         int n = grid.length;
//         int m = grid[0].length;
//         int ans = 0;
        
//         for(int i=0; i<n; i++) {
//             for(int j=0; j<m; j++) {
//                 if(grid[i][j] == '1') {
//                     ans = ans+1;
//                     dfs(grid, i, j, n, m);
//                 }
//             }
//         }
//         return ans;
//     }
// }

class Pair{
    
    int first ; 
    int second ;
    
    public Pair(int first , int second ){
        
        this.first = first ; 
        this.second = second ; 
    }
}

class Solution {
    // Function to find the number of islands.
    public void bfs (char[][] grid , int [][] visited , int ro, int co ){
        
        int n = grid.length ; 
        int m = grid[0].length ; 
        visited[ro][co] = 1 ; 
        Queue<Pair> q = new LinkedList<>() ; 
        q.add(new Pair(ro , co )) ; 
        
        while(!q.isEmpty()){
            
            int row = q.peek().first ; 
            int col = q.peek().second ; 
            q.remove() ; 
            
            for(int delRow = -1 ; delRow<=1 ; delRow++ ){
                for(int delCol = -1 ; delCol<=1 ; delCol++ ){
                    
                    int nRow = row + delRow ; 
                    int nCol = col + delCol ; 
                    
                    if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]== '1' && visited[nRow][nCol]==0 ){
                        
                        visited[nRow][nCol]= 1 ;
                        q.add(new Pair(nRow , nCol )) ; 
                        
                    }
                }
                
            }
        }
        
        
    }
    
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length ; 
        int m = grid[0].length ; 
        int [][] visited = new int[n][m] ; 
        int count = 0 ; 
        
        for(int row = 0 ; row<n ; row++){
            
            for(int col = 0 ; col<m ; col++){
                
                if(visited[row][col] == 0 && grid[row][col]=='1'){
                    
                    count++ ;
                    bfs(grid , visited , row , col ) ;
                }
                
            }
        }
        return count ; 
    }
}