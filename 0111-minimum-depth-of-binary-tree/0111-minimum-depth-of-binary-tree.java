/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int count(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left == null) {
            return 1 + count(root.right);
        }
        if(root.right == null) {
            return 1 + count(root.left);
        }
        return Math.min(count(root.left), count(root.right)) + 1;
    }
    public int minDepth(TreeNode root) {
        return count(root);
    }
}