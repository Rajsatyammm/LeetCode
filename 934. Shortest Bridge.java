// 934. Shortest Bridge

class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int shortestBridge(int[][] grid) {
        
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] visited = new int[rows][columns];
        int islandCount = 0;
        Queue<Pair> queue = new LinkedList<>();


        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    islandCount++;
                    DFS(i, j, grid, visited, islandCount);
                }
                if(visited[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        int count = 0;

        outer: while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair current = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int row = current.row + dx[j];
                    int column = current.column + dy[j];
                    if(!isSafe(row, column, grid) || visited[row][column] == 2) {
                        continue;
                    }
                    if(visited[row][column] == 1) {
                        break outer;
                    }
                    queue.add(new Pair(row, column));
                    visited[row][column] = 2;
                }
            }
            count++;
        }
        return count;
    }

    public void DFS(int i, int j, int[][] grid, int[][] visited, int islandCount) {

        if(!isSafe(i, j, grid) || visited[i][j] == islandCount || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = islandCount;
        for(int x = 0; x < 4; x++) {
            int row = i + dx[x];
            int column = j + dy[x];
            DFS(row, column, grid, visited, islandCount);
        }
    }

    public boolean isSafe(int i, int j, int[][] grid) {

        int rows = grid.length;
        int columns = grid[0].length;
        if(i < 0 || i >= rows || j < 0 || j >= columns) {
            return false;
        }
        return true;
    }

    class Pair {

        int row;
        int column;
        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
