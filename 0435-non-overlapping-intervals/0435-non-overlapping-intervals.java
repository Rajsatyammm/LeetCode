class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        int endTime = intervals[0][1];
        int n = intervals.length;
        
        for(int i=1; i<n; i++) {
            int startTime = intervals[i][0];
            if(endTime <= startTime) {
                // select 
                endTime = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}