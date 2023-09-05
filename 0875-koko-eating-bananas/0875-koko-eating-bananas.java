class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        
        int n = piles.length;
        long max = Long.MIN_VALUE;
        for (int i : piles) {
            max = Math.max(max, i);
        }
        
        long low = 1, high = max;
        long ans = Long.MAX_VALUE;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (minTime(piles, mid) <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    long minTime(int[] piles, long avg) { 
        long totalTime = 0;
        for (int i : piles) {
            totalTime += (i / avg);
            if (i % avg != 0) totalTime += 1;
        }
        return totalTime;
    }
}
