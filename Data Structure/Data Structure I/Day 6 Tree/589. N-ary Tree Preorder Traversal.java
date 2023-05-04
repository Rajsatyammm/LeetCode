// 589. N-ary Tree Preorder Traversal

class Solution {
    private List<Integer> preOrder(Node root, List<Integer> res) {
        res.add(root.val);
        for(Node n : root.children) {
            preOrder(n, res);
        }
        return res;
    }
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        return preOrder(root, res);
    }
}
