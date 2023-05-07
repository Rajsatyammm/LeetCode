// 1964. Find the Longest Valid Obstacle Course at Each Position

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] dp = new int[n];  
        int[] ans = new int[n]; 
        
        int len = 0; 
        
        for (int i = 0; i < n; i++) {
            int idx = binarySearch(dp, 0, len - 1, obstacles[i]); 
            
            dp[idx] = obstacles[i]; 
            
            if (idx == len) { 
                len++; 
            }
            
            ans[i] = idx + 1; 
        }
        
        return ans;
    }

    private int binarySearch(int[] dp, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
