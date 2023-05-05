// 704. Binary Search

class Solution {
    public int search(int[] nums, int target) {
        int lp = 0, rp = nums.length-1;
        while(lp <= rp) {
            int mid = (lp + rp) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return -1;
    }
}
