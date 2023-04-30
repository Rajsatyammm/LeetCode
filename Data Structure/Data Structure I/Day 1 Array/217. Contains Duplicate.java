// 217. Contains Duplicate

import java.util.HashMap;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 1;
        for(int i : nums) {
            if(map.containsKey(i)) {
                return true;
            }
            map.put(i, val);
        }
        return false;
    }
}
