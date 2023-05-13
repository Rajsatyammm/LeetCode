// 169. Majority Element

class Solution {
    public int majorityElement(int[] nums) {
        // Approach 1 :
        Arrays.sort(nums);
        return nums[nums.length/2];  
    }
}
