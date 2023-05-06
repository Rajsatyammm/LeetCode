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


// Approach 2 : 

class Solution {
    public boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) {
            return true;
        }
        if(min != null && min.val >= root.val) {
            return false;
        }
        else if(max != null && max.val <= root.val) {
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
}
