// 144. Binary Tree Preorder Traversal

class Solution {
    private List<Integer> list = new ArrayList<>();
    private void preOrder(TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }
}
