// 94. Binary Tree Inorder Traversal

class Solution {
    private List<Integer> List = new ArrayList<>();
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        List.add(root.val);
        inOrder(root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return List;
    }
}
