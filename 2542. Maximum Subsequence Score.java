// 2542. Maximum Subsequence Score

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][3];
        for(int i=0; i<nums1.length; i++) {
            pairs[i] = new int[] {nums2[i], nums1[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[0]-a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long res = 0, totalSum = 0;
        for(int[] pair : pairs) {
            pq.add(pair[1]);
            totalSum += pair[1];

            if(pq.size() > k) {
                totalSum -= pq.remove();
            } 
            if(pq.size() == k) {
                res = Math.max(res, totalSum * pair[0]);
            }
        }
        return res;
    }
}
