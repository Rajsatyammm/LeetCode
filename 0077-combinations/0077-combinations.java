class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(1, n, k, new ArrayList<Integer>(), result);
        return result;
    }

    private void generateCombinations(int start, int n, int k, List<Integer> list,List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            generateCombinations(i + 1, n, k - 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}