/*
Combination Sum
Medium
15.5K
308
Companies
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return rst;
        }

        Arrays.sort(candidates);
        dfs(rst, new ArrayList<>(), candidates, 0, target);
        return rst;
    }

    public void dfs(List<List<Integer>> rst, List<Integer> list, int[] candidates,
                    int startIndex, int remainTarget) {
        if (remainTarget == 0) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > remainTarget) {
                break;
            }
            list.add(candidates[i]);
            dfs(rst, list, candidates, i, remainTarget - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}
