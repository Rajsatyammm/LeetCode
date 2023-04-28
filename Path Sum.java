/*
112. Path Sum
Easy
8.2K
932
Companies
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
*/
Approach 1 : 

class Solution {
    private boolean hasPath(TreeNode root, int tar, int curr) {
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
        return hasPath(root.left, tar, curr) || hasPath(root.right, tar, curr);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPath(root, targetSum, 0);
    }
}


Approach 2 : 

class Solution {
    private boolean pathSum(TreeNode root, int tar) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            if(root.val == tar) {
                return true;
            }
        }
        return pathSum(root.left, (tar - root.val)) || pathSum(root.right, (tar - root.val));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum);
    }
}
