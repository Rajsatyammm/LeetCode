class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;
        
        for(int num : arr) {
            int prevNum = num - difference;
            if(dp.containsKey(prevNum)) 
                dp.put(num, dp.get(prevNum) + 1);
            else 
                dp.put(num, 1);
            maxLen = Math.max(maxLen, dp.get(num));
        }
        return maxLen;
    }
}