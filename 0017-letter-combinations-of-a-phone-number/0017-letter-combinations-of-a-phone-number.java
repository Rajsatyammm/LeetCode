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