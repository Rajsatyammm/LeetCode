/*
40. Combination Sum II
Medium
8.2K
204
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new LinkedList<>();
        }

        List<List<Integer>> rst = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new LinkedList<>(), rst);
        return rst;
    }

    private void dfs(int[] candidates, int index, int remainTraget, LinkedList<Integer> list, List<List<Integer>> rst) {
        if (remainTraget == 0) {
            rst.add(new LinkedList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 当 remainTarget < candidates[i] 时,可以直接结束递归
            // 以起到加速效果
            if (remainTraget < candidates[i]) {
                break;
            }
            if (i != index && candidates[i - 1] == candidates[i]) {
                continue;
            }

            list.add(candidates[i]);
            dfs(candidates, i + 1, remainTraget - candidates[i], list, rst);
            list.remove(list.size() - 1);
        }
    }
}
