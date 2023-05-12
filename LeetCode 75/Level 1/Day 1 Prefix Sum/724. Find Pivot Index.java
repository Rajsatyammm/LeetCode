// 724. Find Pivot Index

class Solution {
    public int pivotIndex(int[] nums) {
        // Approach : 1
        // int N = nums.length;
        // int left[] = new int[N];
        // int right[] = new int[N];
        // int idx = -1;
        
        // left[0] = nums[0];
        // for(int i=1; i<N; i++) {
        //     left[i] = left[i-1] + nums[i];
        // }
        // right[N-1] = nums[N-1];
        // for(int i=N-2; i>=0; i--) {
        //     right[i] = right[i+1] + nums[i];
        // }

        // for(int i = 0; i<N; i++) {
        //     if(left[i] == right[i]) {
        //         idx = i;
        //         break;
        //     }
        // }
        // return idx;

        int lsum = 0, total = 0;
        for(int i: nums) {
            total += i;
        }

        for(int j=0; j<nums.length; lsum += nums[j++]) {
            if(lsum * 2 == total - nums[j]) {
                return j;
            }
        }
        return -1;
    }
}
