class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        int maxLength = 0;
        int dp[] = new int[n];
        int count[] = new int[n];

        for(int idx = 0; idx < n; idx++){
            dp[idx] = count[idx] = 1;
            for(int prevIdx = 0; prevIdx < idx; prevIdx++){
                if(nums[prevIdx] < nums[idx] && dp[idx] < 1 + dp[prevIdx]){
                    dp[idx] = 1 + dp[prevIdx];
                    count[idx] = count[prevIdx];
                } else if(nums[prevIdx] < nums[idx] && dp[idx] == 1 + dp[prevIdx]){
                    count[idx] += count[prevIdx];
                }
            }
            maxLength = Math.max(maxLength, dp[idx]);
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxLength){
                result += count[i];
            }
        }

        return result;   
    }
}