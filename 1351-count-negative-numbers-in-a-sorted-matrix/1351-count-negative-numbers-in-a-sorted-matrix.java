class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int[] arr : grid) {
            for(int a : arr) {
                if(a < 0) count++;
            }
        }
        return count;
    }
}