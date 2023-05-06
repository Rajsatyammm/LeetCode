// 98. Validate Binary Search Tree

// Approach 1 : 
// find inOrder Sequence if it is Sorted then tree is BST
class Solution {
    private List<Integer> al = new ArrayList<>();
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        al.add(root.val);
        inOrder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for(int i=1; i<al.size(); i++) {
            if(al.get(i) <= al.get(i-1)) {
                return false;
            }
        }
        return true;
    }
}
