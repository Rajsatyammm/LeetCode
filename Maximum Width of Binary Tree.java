/*
662. Maximum Width of Binary Tree
Medium
7.2K
981
Companies
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
Explanation: The maximum width exists in the fourth level with length 7 (6,null,null,null,null,null,7).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width exists in the second level with length 2 (3,2).
 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100
*/

class Solution {
  public int widthOfBinaryTree(TreeNode root) {
    int maxWidth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    Map<TreeNode, Integer> map = new HashMap<>();
    map.put(root, 1);
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      int start = 0;
      int end = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (i == 0) {
          start = map.get(node);
        }
        if (i == size - 1) {
          end = map.get(node);
        }
        if (node.left != null) {
          map.put(node.left, map.get(node) * 2);
          queue.add(node.left);
        }
        if (node.right != null) {
          map.put(node.right, map.get(node) * 2 + 1);
          queue.add(node.right);
        }
      }
      maxWidth = Math.max(maxWidth, end - start + 1);
    }
    return maxWidth;
  }
}
