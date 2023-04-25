/*
239. Sliding Window Maximum
Hard
14.2K
461
Companies
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
*/



class Solution {
    class Node implements Comparable<Node>{
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
