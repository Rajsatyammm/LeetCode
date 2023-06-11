class SnapshotArray {
    int snap_id = 0;
    HashMap<Integer, ArrayList<Integer>> h1;
    HashMap<Integer, ArrayList<Integer>> h2;
    public SnapshotArray(int length) {
        h1 = new HashMap<>();
        h2 = new HashMap<>();
    }
    
    public void set(int index, int val) {
        if(!h1.containsKey(index)) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(snap_id);
            h1.put(index, l);
            ArrayList<Integer> al = new ArrayList<>();
            al.add(val);
            h2.put(index, al);
        }
        else {
            ArrayList<Integer> l = h1.get(index);
            int len = l.size() - 1;
            if(l.get(len) == snap_id) {
                ArrayList<Integer> al = h2.get(index);
                al.remove(len);
                al.add(val);
                h2.put(index, al);
            }
            else {
                l.add(snap_id);
                h1.put(index, l);
                ArrayList<Integer> al =  h2.get(index);
                al.add(val);
                h2.put(index, al);
            }
        }
    }
    
    public int snap() {
        snap_id++;
        return snap_id-1;
    }
    
    public int get(int index, int snap_id) {
        if(!h1.containsKey(index)) {
            return 0;
        }
        else {
            ArrayList<Integer> l = h1.get(index);
            ArrayList<Integer> al = h2.get(index);
            int low = 0, high = l.size()-1;
            int result = 0;
            while(low <= high) {
                int mid = (low + high) / 2;
                if(l.get(mid) == snap_id) {
                    return al.get(mid);
                }
                else if(l.get(mid)>snap_id) {
                    high = mid-1;
                }
                else {
                    result = al.get(mid);
                    low = mid+1;
                }
            }
            return result;
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */