// 205. Isomorphic Strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
//       Approach : 1
        // if(s.length() != t.length()) return false;
        // int[] map1 = new int[256];
        // int[] map2 = new int[256];

        // for(int i=0; i<s.length(); i++) {
        //     if(map1[s.charAt(i)] != map2[t.charAt(i)]) {
        //         return false;
        //     }
        //     map1[s.charAt(i)] = i + 1;
        //     map2[s.charAt(i)] = i + 1;

        // }
        // return true;

//       Approach : 2
        HashMap<Character,Character>hm=new HashMap<>();
        boolean[]vis=new boolean[128];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hm.containsKey(ch)){
                if(hm.get(ch)!=t.charAt(i))return false;
            }else{
                if(vis[t.charAt(i)]) return false;
                vis[t.charAt(i)]=true;
                hm.put(ch,t.charAt(i));
            }
        }
        return true;
    }
}
