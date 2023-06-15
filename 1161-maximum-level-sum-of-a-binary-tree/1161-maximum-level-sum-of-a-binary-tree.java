class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp = root;
        if(root == null)
            return 0;
        q.add(root);
        int max = Integer.MIN_VALUE;
        int lv = 1, ans = 1;
            while(!q.isEmpty()){
                int size = q.size();
                int sum = 0;
                for(int i=0; i<size; i++) {
                    temp = q.poll();
                    if(temp.left != null)
                        q.add(temp.left);
                    if(temp.right != null)
                        q.add(temp.right);
                    sum += temp.val;
                }
                if(max < sum) {
                    max = sum;
                    ans = lv;
                }
                lv++;
            }
        return ans;
    }
}