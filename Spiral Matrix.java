/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]


Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/



class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int startRow = 0;
        int startColm = 0;
        int endRow = matrix.length-1;
        int endColm = matrix[0].length-1;

        while(startRow <= endRow && startColm <= endColm) {
            
            //Upper Boundary
            for(int j=startColm; j <= endColm; j++) {
                list.add(matrix[startRow][j]);
            }

            //Right Boundary
            for(int i=startRow + 1; i<=endRow; i++) {
                list.add(matrix[i][endColm]);
            }

            //Bottom Boundary
            for(int j=endColm-1; j>=startColm; j--) {
                if(startRow == endRow) {
                    break;
                }
                list.add(matrix[endRow][j]);
            }

            //Left Boundary
            for(int i=endRow-1; i>=startRow+1; i--) {
                if(startColm == endColm) {
                    break;
                }
                list.add(matrix[i][startColm]);
            }

            startRow++;
            startColm++;
            endRow--;
            endColm--;
        }
        return list;
    }
}
