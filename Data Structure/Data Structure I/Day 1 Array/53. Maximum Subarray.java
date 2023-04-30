// 53. Maximum Subarray

class Solution {
    public int maxSubArray(int[] nums) {
        //Kadans Algo
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for(int i : nums) {
            currSum += i;
            maxSum = Math.max(currSum, maxSum);

            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
