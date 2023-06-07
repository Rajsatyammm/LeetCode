class Solution {
    public int countWords(String[] words1, String[] words2) {
        
//         Approach 1 : 
        
//         Map<String, Integer> map1 = new HashMap<>();
//         Map<String, Integer> map2 = new HashMap<>();
//         for(int i=0; i<words1.length; i++) {
//             map1.put(words1[i], map1.getOrDefault(words1[i], 0) + 1);
//         }
        
//         for(int j=0; j<words2.length; j++) {
//             map2.put(words2[j], map2.getOrDefault(words2[j], 0) + 1);
//         }
        
//         Set<String> s1 = new HashSet<>();
//         Set<String> s2 = new HashSet<>();
        
//         for(String s : map1.keySet()) {
//             if(map1.get(s) == 1) s1.add(s);
//         }
        
//         for(String s : map2.keySet()) {
//             if(map2.get(s) == 1) s2.add(s);
//         }
        
//         int count = 0;
//         for(String s : s1) {
//             if(s2.contains(s)) {
//                 count++;
//             }
//         }
//         return count;
        
        
        // Approach 2 : 
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i=0; i<words1.length; i++) {
            map1.put(words1[i], map1.getOrDefault(words1[i], 0) + 1);
        }
        
        for(int j=0; j<words2.length; j++) {
            map2.put(words2[j], map2.getOrDefault(words2[j], 0) + 1);
        }
        
        int count = 0;
        for(int i=0; i<words1.length; i++) {
            String str = words1[i];
            if(map2.containsKey(str) && map2.get(str) == 1 && map1.get(str) == 1) count++;
        }
        
        return count;
    }
}