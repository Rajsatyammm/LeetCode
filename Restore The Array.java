/*
1416. Restore The Array
Hard
578
26
Companies
A program was supposed to print an array of integers. The program forgot to print whitespaces and the array is printed as a string of digits s and all we know is that all integers in the array were in the range [1, k] and there are no leading zeros in the array.

Given the string s and the integer k, return the number of the possible arrays that can be printed as s using the mentioned program. Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: s = "1000", k = 10000
Output: 1
Explanation: The only possible array is [1000]
Example 2:

Input: s = "1000", k = 10
Output: 0
Explanation: There cannot be an array that was printed this way and has all integer >= 1 and <= 10.
Example 3:

Input: s = "1317", k = 2000
Output: 8
Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]
 

Constraints:

1 <= s.length <= 105
s consists of only digits and does not contain leading zeros.
1 <= k <= 109
*/




class Solution {
    int[] DP;
    int MOD = (int) 1e9 + 7;

    public int numberOfArrays(String s, int k) {
        DP = new int[s.length() + 1];
        Arrays.fill(DP, -1);
        return dp(0, s, k);
    }

    private int dp(int i, String s, int k) {
        if (i == s.length()) return 1;
        else if (DP[i] != -1) return DP[i];
        else if (s.charAt(i) == '0') return 0;
        else {
            long sum = 0L;
            String num = "";
            for (int j = i; j < (i + 10) && j < s.length(); j++) {
                num = num + s.charAt(j);
                if (Long.parseLong(num) <= k) {
                    sum = ((sum + dp(j + 1, s, k)) % MOD);
                }
            }
            DP[i] = (int) sum;
            return DP[i];
        }
    }
}
