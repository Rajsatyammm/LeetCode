// 74. Search a 2D Matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, colm = matrix[0].length-1;
        while(row <= matrix.length-1 && colm >= 0) {
            if(matrix[row][colm] == target) {
                return true;
            }
            else if(matrix[row][colm] > target) {
                colm--;
            }
            else {
                row++;
            }
        }
        return false;
    }
}
