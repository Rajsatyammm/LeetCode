// 238. Product of Array Except Self

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Approach 1 : 
        // int n = nums.length;
        // int[] res = new int[n];

        // int[] Left = new int[n];
        // Left[0] = 1;
        // Left[1] = nums[0];
        // for(int i=2; i<n; i++) {
        //     Left[i] = Left[i-1] * nums[i-1];
        // }

        // int[] Right = new int[n];
        // Right[n - 1] = 1;
        // Right[n - 2] = nums[n -1];
        // for(int i=n-3; i>=0; i--) {
        //     Right[i] = Right[i+1] * nums[i+1];
        // }

        // for(int i=0; i<n; i++) {
        //     res[i] = Left[i] * Right[i];
        // }
        // return res;


        // Approach 2 : 
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
