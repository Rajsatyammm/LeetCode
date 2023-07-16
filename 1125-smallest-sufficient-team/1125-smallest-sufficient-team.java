class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillIndexMap = new HashMap<>();

        for (int i = 0; i < req_skills.length; i++) {
            skillIndexMap.put(req_skills[i], i);
        }
        int[] peopleSkillBitMask = new int[people.size()];

        for (int i = 0; i < people.size(); i++) {
            List<String> personSkill = people.get(i);
            int mask = 0;

            for (String skill : personSkill){
                mask |= 1 << skillIndexMap.get(skill); //setting bit at that index indicating skills that person has
            }
            peopleSkillBitMask[i] = mask;
        }
        int endState = (1 << req_skills.length) - 1; //setting all bits indicating all skills
        Map<String, Long> memo = new HashMap<>();
        long state = recur(peopleSkillBitMask, endState ,0, 0, memo);
        List<Integer> holder = new ArrayList<>();
        int index = 0;
        System.out.println(Long.toBinaryString(state));

        while (state > 0) {
            long ans = state & 1;

            if (ans == 1) {
                holder.add(index);
            }
            index++;
            state >>= 1;
        } 
        int[] ans = new int[holder.size()];

        for (int i = 0; i < holder.size(); i++) {
            ans[i] = holder.get(i);
        }
        return ans;
    }

    private long recur(int[] peopleSkillBitMask, int endState, int index, int mask, Map<String, Long> memo) {
        
        if (mask == endState) {
            return 0;
        }

        if (index == peopleSkillBitMask.length) {
            return Integer.MAX_VALUE;
        }
        String key = index + "|" + mask;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        long ans = 0;
        //Setting the bit to signify including of skills
        long include = recur(peopleSkillBitMask, endState, index + 1, mask | peopleSkillBitMask[index], memo);
        long exclude = recur(peopleSkillBitMask, endState, index + 1, mask, memo);
        // Setting the bit as indicator that it has been included or excluded
        // Using Long as 1 <= people.length <= 60
        if (Long.bitCount(include) < Long.bitCount(exclude)) {
            ans =  include | (1L << index);
        } else {
            ans = exclude;
        }
        memo.put(key, ans);
        return ans;
    }

}