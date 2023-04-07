/*
5. Longest Palindromic Substring
Medium
24.6K
1.4K
Companies
Given a string s, return the longest 
palindromic
 
substring
 in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int n = s.length(), start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int len_odd = expandAroundCenter(s, i, i);
            int len_even = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len_odd, len_even);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right, n = s.length();
        
        while(L >= 0 && R < n && s.charAt(L) == s.charAt(R) ) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
