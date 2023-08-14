class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];
        
        for(int i=0; i<n-1; i++) arr1[i] = nums[i];
        for(int i=1; i<n; i++) arr2[i-1] = nums[i];
        
        return Math.max(helper(arr1), helper(arr2));
    }
    
    private int helper(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for(int i=2; i<=n; i++) {
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }
        return dp[n];
    }
}