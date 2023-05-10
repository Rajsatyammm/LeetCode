// 226. Invert Binary Tree

class Solution {
    private TreeNode invert(TreeNode root) {
        if(root == null) {
            return root;
        }
        invert(root.left);
        invert(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
}
