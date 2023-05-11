// 700. Search in a Binary Search Tree

class Solution {
    private TreeNode search(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        else if(root.val < val) return search(root.right, val);
        else if(root.val > val) return search(root.left, val);
        return null;
        
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }
}
