// 1046. Last Stone Weight

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }

        while(!(pq.size() == 1)) {
            int x = pq.remove();
            int y = pq.remove();

            if(x > y) {
                pq.add(x-y);
            } else if(y > x) {
                pq.add(y-x);
            } else {
                pq.add(0);
            }
        }

        return pq.remove();
    }
}
