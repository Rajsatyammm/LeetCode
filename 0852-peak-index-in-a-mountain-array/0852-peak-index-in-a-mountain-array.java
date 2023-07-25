class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        // Approach 1 : Linear Search T(n) = O(n)
        // int idx = 0, max = Integer.MIN_VALUE;
        // for(int i=0; i<arr.length; i++) {
        //     if(arr[i] > max) {
        //         idx = i;
        //         max = arr[i];
        //     }
        // }
        // return idx;

        // Approach 2 : Binary Search T(n) = O(log n)
        int st = 0, end = arr.length, ans = 0;
        while(st < end) {
            int mid = st + (end - st) / 2;
            if(arr[mid] > arr[mid+1]) {
                ans = mid;
                end = mid;
            } else {
                ans = mid + 1;
                st = mid + 1;
            }
        }
        return ans;
    }
}