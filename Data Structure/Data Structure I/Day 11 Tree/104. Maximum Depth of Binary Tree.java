// 104. Maximum Depth of Binary Tree

class Solution {
    private int calDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = calDepth(root.left);
        int right = calDepth(root.right);

        return Math.max(left, right) + 1;
    }
    public int maxDepth(TreeNode root) {
        
        return calDepth(root);
    }
}
