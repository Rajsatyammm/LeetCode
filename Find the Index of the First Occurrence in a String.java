/*
28. Find the Index of the First Occurrence in a String
Easy
3.2K
153
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
*/



public class Solution {
    public int strStr(String haystack, String needle) {
        
        if (haystack == null || needle == null)
            return -1;
            
        int start = 0;
        int len = needle.length();
        
        while (start + len <= haystack.length()) {
            if (haystack.substring(start, start+len).equals(needle))
                return start;
            start++;
        }
        
        return -1;
        
    }
}
