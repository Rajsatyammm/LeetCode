/*
108. Convert Sorted Array to Binary Search Tree
Easy
9.4K
473
Companies
Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced
 binary search tree.

 

Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
*/


class Solution {
    private TreeNode buildBST(int[] arr, int si, int ei) {
        if(si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBST(arr, si, mid-1);
        root.right = buildBST(arr, mid+1, ei);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int si = 0;
        int ei = nums.length-1;
        return buildBST(nums, si, ei);
    }
}
