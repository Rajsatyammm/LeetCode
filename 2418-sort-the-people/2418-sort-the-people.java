class Solution {
    static class Info implements Comparable<Info> {
        String str;
        int ht;
        
        Info(String s, int ht) {
            str = s;
            this.ht = ht;
        }
        
        @Override
        public int compareTo(Info i) {
            return i.ht - this.ht;
        }
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0; i<names.length; i++) {
            pq.add(new Info(names[i], heights[i]));
        }
        
        String[] str = new String[names.length];
        for(int i=0; i<str.length; i++) {
            str[i] = pq.remove().str;
        }
        
        return str;
        
    }
}