// 200. Number of Islands

class Solution {

    //cheaking the grid location is valid or not
    private boolean isValid(char[][] grid, int r, int c, int n, int m) {
        if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == '1') {
            return true;
        }
        return false;
    }

    
    private void numIslandsDFS(char[][] grid, int r, int c, int n, int m) {
        grid[r][c] = '0';

        if(isValid(grid, r+1, c, n, m))
            numIslandsDFS(grid, r+1, c, n, m);

        if(isValid(grid, r-1, c, n, m))
            numIslandsDFS(grid, r-1, c, n, m);

        if(isValid(grid, r, c+1, n, m))
            numIslandsDFS(grid, r, c+1, n, m);

        if(isValid(grid, r, c-1, n, m))
            numIslandsDFS(grid, r, c-1, n, m);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(grid[r][c] == '1') {
                    ans++;
                    numIslandsDFS(grid, r, c, n, m);
                }
            }
        }
        return ans;
    }
}
