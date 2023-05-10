// 112. Path Sum

class Solution {
    private boolean pathSum(TreeNode root, int tar, int curr) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            curr += root.val;
            if(tar == curr) {
                return true;
            }
        }

        curr += root.val;
        return pathSum(root.left, tar, curr) || pathSum(root.right, tar, curr);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPath(root, targetSum, 0);
    }
}
