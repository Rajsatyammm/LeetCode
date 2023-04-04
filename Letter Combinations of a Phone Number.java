/*
17. Letter Combinations of a Phone Number
Medium
14.6K
825
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/



class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if(null != digits && digits.length() == 0) return result;
        result.add("");
        String[] d = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        int len = digits.length();
        for(int i = 0; i < len; i++){
            List<String> tempResult = new LinkedList<>();
            String current = d[new Integer("" + digits.charAt(i))];
            int tempLenth = current.length();
            for(String s : result){
                for(int j = 0; j < tempLenth; j++)
                    tempResult.add(s + current.charAt(j));
            }
            result = tempResult;
        }
        return result;
    }
}
