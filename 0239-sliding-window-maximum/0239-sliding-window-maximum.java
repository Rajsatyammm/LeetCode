class Solution {
    class Node implements Comparable<Node> {
        int val;
        int idx;

        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node n) {
            return n.val - this.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int n = nums.length;
        int res[] = new int[n-k+1];

        for(int i=0; i<k; i++) {
            pq.add(new Node(nums[i], i));
        }

        res[0] = pq.peek().val;

        for(int i=k; i<n; i++) {
            while(pq.size() > 0 && pq.peek().idx <= (i-k)) { 
                pq.remove();
            }
            pq.add(new Node(nums[i], i));
            res[i-k+1] = pq.peek().val;
        }
        return res;
    }
}