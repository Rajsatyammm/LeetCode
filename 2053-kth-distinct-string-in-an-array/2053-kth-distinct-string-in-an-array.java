class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        HashMap<String, Integer> map= new HashMap<>();
        for(String s : arr) map.put(s, map.getOrDefault(s, 0) + 1);

        List<String> al = new ArrayList<>(); 
        for(String s: arr) if(map.get(s) == 1) al.add(s);

        if(al.size() >= k) return al.get(k-1);

        return "";
    }
}