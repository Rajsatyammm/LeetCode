// 242. Valid Anagram

class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);

            if(!map.containsKey(ch)) {
                return false;
            }
            else {
                int freq = map.get(ch);
                if(freq == 1) {
                    map.remove(ch);
                }
                else {
                    map.put(ch, freq - 1);
                }
            }
        }
        if(!map.isEmpty()) {
            return false;
        }
        return true;
    }
}


// Apporoach 2 : 

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}
