// 844. Backspace String Compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> S = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '#') {
                if(!S.isEmpty()) {
                    S.pop();
                }
            } 
            else {
                S.push(ch);
            }
        }

        Stack<Character> T = new Stack<>();
        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if(ch == '#') {
                if(!T.isEmpty()) {
                    T.pop();
                }
            } else {
                T.push(ch);
            }
        }

        if(S.size() != T.size()) {
            return false;
        }
        while(!S.isEmpty()) {
            if(S.peek() != T.peek()) {
                return false;
            }
            S.pop();
            T.pop();
        }
        
        return true;
    }
}
