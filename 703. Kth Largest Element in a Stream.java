// 703. Kth Largest Element in a Stream

class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int gk = 0;
    public KthLargest(int k, int[] nums) {
        gk = k;
        for(int i=0; i<nums.length; i++) pq.add(nums[i]);
        if(pq.size() > k) pq.remove();
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > gk) pq.remove();
        return pq.peek();
    }
}
