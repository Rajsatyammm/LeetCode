class MyHashMap {

    Map<Integer, Integer> map;
    public MyHashMap() {
        map = new HashMap<>();
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
    
    public int get(int key) {
        if(map.get(key) == null) {
            return -1;
        }
        else {
            return map.get(key);
        }
    }
    
    public void remove(int key) {
        map.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */