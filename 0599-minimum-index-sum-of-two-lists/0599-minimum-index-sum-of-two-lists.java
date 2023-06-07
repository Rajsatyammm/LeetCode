class Solution {
    static class Info implements Comparable<Info> { 
        String str;
        int freq;
        
        public Info(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(Info i) {
            return this.freq - i.freq;
        }
    }
    
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Info> pq = new PriorityQueue<>();
        ArrayList<String> al = new ArrayList<>();
        
        for(int i=0; i<list1.length; i++) {
            map.put(list1[i], i);
        }
        
        for(int i=0; i<list2.length; i++) {
            if(map.containsKey(list2[i])) {
                int idxSum = map.get(list2[i]) + i;
                pq.add(new Info(list2[i], idxSum));
            }
        }
        
        if(pq.size() == 1) {
            al.add(pq.remove().str);
            return al.toArray(new String[al.size()]);
        }
        
        else {
            int min = pq.peek().freq;
            while(!pq.isEmpty() && pq.peek().freq == min) {
                al.add(pq.remove().str);
            }
        }
        
        return al.toArray(new String[al.size()]);
    }
}