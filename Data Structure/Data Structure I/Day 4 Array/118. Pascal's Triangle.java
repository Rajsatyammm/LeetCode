// 118. Pascal's Triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }
        arr.add(1);
        result.add(arr);
        
        for(int i=2; i<=numRows; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=0; j<arr.size()-1; j++) {
                curr.add(arr.get(j) + arr.get(j+1));
            }
            curr.add(1);
            result.add(curr);
            arr = curr;
        }
        return result;
    }
}
