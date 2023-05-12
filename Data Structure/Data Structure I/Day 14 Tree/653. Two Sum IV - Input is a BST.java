// 653. Two Sum IV - Input is a BST

class Solution {
    private Set<Integer> s = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(s.contains(k - root.val)) return true;
        s.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}