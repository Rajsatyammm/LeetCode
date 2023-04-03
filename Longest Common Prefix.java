/*
14. Longest Common Prefix
Easy
13.3K
3.8K
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
*/





class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { return ""; }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            int j = 0;
            while (j < prefix.length() && j < s.length() &&
                   prefix.charAt(j) == s.charAt(j)) {
                j += 1;
            }
            prefix = prefix.substring(0, j);
            if (prefix.length() == 0) { break; }
        }
        return prefix;
    }
}
