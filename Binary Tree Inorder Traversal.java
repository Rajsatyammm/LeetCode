/*
94. Binary Tree Inorder Traversal
Easy
11.3K
566
Companies
Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
*/




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
