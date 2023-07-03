class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s == null || goal == null || s.length() < 2) return false;
        if(s.length() != goal.length()) return false;

        List<Integer> unMatched = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)) unMatched.add(i);
            if(unMatched.size() > 2) return false;
        }
        if(unMatched.isEmpty()){
            int[] alpha = new int[26];
            for(int i=0; i<s.length(); i++){
                alpha[s.charAt(i)-'a']++;
                if(alpha[s.charAt(i)-'a']>1){
                    return true;
                }
            }
        }
        return unMatched.size() == 2 &&
        s.charAt(unMatched.get(0)) == goal.charAt(unMatched.get(1)) &&
        s.charAt(unMatched.get(1)) == goal.charAt(unMatched.get(0));
    }
}