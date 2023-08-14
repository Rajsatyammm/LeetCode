class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Approach 1 : 
        // Using Max Heap
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // for(int i=0; i<nums.length; i++) {
        //     pq.add(nums[i]);
        // }
        // for(int i=0; i<k-1; i++) {
        //     pq.remove();
        // }
        // return pq.remove();

        // Approach 2 :
        // Arrays.sort(nums);
        // return nums[nums.length - k];

        // Approach 3 : 
        // Using Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for(; i<k; i++) {
            pq.add(nums[i]);
        }
        while(i < nums.length) {
            pq.add(nums[i]);
            pq.remove();
            i++;
        }
        return pq.remove();
    }
}