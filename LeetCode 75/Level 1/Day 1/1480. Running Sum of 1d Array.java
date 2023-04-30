// 1480. Running Sum of 1d Array

class Solution {
    public int[] runningSum(int[] nums) {

        int N = nums.length;
        int[] ans = new int[N];

        // Approach 1:
        // for(int i=0; i<N; i++) {
        //     int sum = 0;
        //     for(int j=0; j<=i; j++) {
        //         sum += nums[j];
        //     }
        //     ans[i] = sum;
        // }
        // return ans;

        // Approach 2 : 
        ans[0] = nums[0];
        for(int i=1; i<N; i++) {
            ans[i] = ans[i-1] + nums[i];
        }
        return ans;

    }
}
