// 145. Binary Tree Postorder Traversal

class Solution {
    private List<Integer> list = new ArrayList<>();
    private void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return list;
    }
}
