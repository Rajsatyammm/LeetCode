class Solution {
    public int differenceOfSum(int[] nums) {
        int totalSum = 0;
        int digitSum = 0;
        for(int i=0; i<nums.length; i++) {
            int temp = nums[i];
            totalSum += temp;
            
            while(temp != 0) {
                digitSum += temp % 10;
                temp = temp / 10;
            }
        }
        return Math.abs(totalSum - digitSum);
    }
}