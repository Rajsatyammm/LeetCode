class Solution {

    public int shortestPathAllKeys(String[] grid) {
        
        int m = grid.length;
        int n = grid[0].length();
        int allKeys = 0;
        int startRow = -1;
        int startCol = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Find the initial position and count the total number of keys
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startRow = i;
                    startCol = j;
                } else if (c >= 'a' && c <= 'f') {
                    allKeys |= (1 << (c - 'a'));
                }
            }
        }

        // Create a queue to perform BFS
        Queue<State> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][64]; // 3D array to track visited states

        // Add the initial state to the queue and mark it as visited
        State initialState = new State(startRow, startCol, 0);
        queue.offer(initialState);
        visited[startRow][startCol][0] = true;

        int steps = 0; // Variable to keep track of the number of steps

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State currentState = queue.poll();

                // Check if all keys are collected
                if (currentState.keys == allKeys) return steps;
                
                // Explore in all the four directions
                for (int[] direction : directions) {
                    int newRow = currentState.row + direction[0];
                    int newCol = currentState.col + direction[1];

                    // Check if the new position is within the grid boundaries
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        char newCell = grid[newRow].charAt(newCol);

                        // If the new position is a wall, skip it
                        if (newCell == '#') continue;
                        
                        int newKeys = currentState.keys;

                        // If the new position is a key, update the collected keys
                        if (newCell >= 'a' && newCell <= 'f') newKeys |= (1 << (newCell - 'a'));
                        

                        // If the new position is a lock and we don't have the corresponding key, skip it
                        if (newCell >= 'A' && newCell <= 'F' && 
                        ((currentState.keys >> (newCell - 'A')) & 1) == 0) continue;
                        

                        // Create a new state with the updated position and collected keys
                        if (!visited[newRow][newCol][newKeys]) {
                            State newState = new State(newRow, newCol, newKeys);
                            queue.offer(newState);
                            visited[newRow][newCol][newKeys] = true;
                        }
                    }
                }
            }
            // Increment the number of steps after exploring all the posibilities at the current level
            steps++; 
        }
        // If it's not possible to collect all keys
        return -1;
    }

    // Custom Class to represent the state of the grid
    private class State {
        int row;
        int col;
        int keys;

        public State(int row, int col, int keys) {
            this.row = row;
            this.col = col;
            this.keys = keys;
        }
    }
}
