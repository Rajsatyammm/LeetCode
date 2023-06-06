class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            if(nums[i] < nums[i + 1]) {
                for(int j = i + 1; j < n - 1; j++){
                    if(nums[j] > nums[j + 1]) return false;
                }
                return true;

            } else if(nums[i] > nums[i + 1]) {
                for(int j = i + 1; j < n - 1; j++) {
                    if(nums[j] < nums[j + 1]) return false;
                }
                return true;
            }
        }
        return true;
    }
}