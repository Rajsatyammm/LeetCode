class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;

        int deltaX = coordinates[0][0];
        int deltaY = coordinates[0][1];

        for (int i = 1; i < len; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }

        // y = kx, as y - kx = 0, ax + by = 0
        int A = -coordinates[1][1];
        int B = coordinates[1][0];
        for (int i = 2; i < len; i++) {
            if (A * coordinates[i][0] + B * coordinates[i][1] != 0) {
                return false;
            }
        }

        return true;  
    }
}