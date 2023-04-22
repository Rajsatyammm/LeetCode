/*
1312. Minimum Insertion Steps to Make a String Palindrome
Hard
3.2K
38
Companies
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/



public int minInsertions(String s) {
        if (s == null || s.length() < 2) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int size = 2; size <= n; ++size) {
            for (int i = 0, j = size - 1; j < n; ++i, ++j) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
            }
        }
        return dp[0][n - 1];
    }
