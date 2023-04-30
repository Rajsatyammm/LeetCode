// 88. Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Approach 1 : T(n) = O(n log n)
        for(int j=0, i=m; j<n; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);

        // Approach : 2 T(n) = O(n)
        // int[] res = new int[m];
        // for(int i=0; i<m; i++) {
        //     res[i] = nums1[i];
        // }

        // int i=0, j=0, k=0;
        // while(i < res.length && j < nums2.length) {
        //     if(res[i] <= nums2[j]) {
        //         nums1[k] = res[i];
        //         i++;
        //     }
        //     else {
        //         nums1[k] = nums2[j];
        //         j++;
        //     }
        //     k++;
        // }

        // while(i < res.length) {
        //     nums1[k] = res[i];
        //     k++; i++;
        // }

        // while(j < nums2.length) {
        //     nums1[k] = nums2[j];
        //     k++; j++;
        // }


    }
}
