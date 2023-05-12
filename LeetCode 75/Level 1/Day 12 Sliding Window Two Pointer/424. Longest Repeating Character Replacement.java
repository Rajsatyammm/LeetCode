// 424. Longest Repeating Character Replacement

class Solution {
    public int characterReplacement(String s, int k) {
                int[] arr = new int[26];
        int largestCount = 0, start = 0, maxlen = 0;
        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - 'A']++;
            // largestCount = unique character in the current window...
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);
            if(end - start + 1 - largestCount > k){ 
                arr[s.charAt(start) - 'A']--;
                start ++;
            }
            // maxlen = maximum length of repeating character & end - start + 1 = size of the current window...
            maxlen = Math.max(maxlen, end - start + 1);
        }
        return maxlen;
    }
}