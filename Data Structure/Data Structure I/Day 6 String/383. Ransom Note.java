// 383. Ransom Note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if(magazine.length() < ransomNote.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if(!map.containsKey(ch)) {
                return false;
            }
            else{
                int freq = map.get(ch);
                if(freq == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, freq-1);
                }
            }
        }
        return true;
    }
}
