class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length, max = Integer.MIN_VALUE;
        for(int i : nums) max = Math.max(max, i);

        int low = 0, high = max;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(mid != 0 && f(nums, mid, threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean f(int[] nums, int val, int t) {
        int total = 0;
        for(int i : nums) {
            total += i / val;
            if(i % val != 0) total += 1;
        }
        return total <= t;
    }
}