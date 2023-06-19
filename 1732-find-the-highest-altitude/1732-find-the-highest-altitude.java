class Solution {
    public int largestAltitude(int[] gain) {
        int higAlt = 0;
        int currVal = 0;
        for(int i=0; i<gain.length; i++) {
            currVal += gain[i];
            higAlt = Math.max(higAlt, currVal);
        }
        return higAlt;

    }
}