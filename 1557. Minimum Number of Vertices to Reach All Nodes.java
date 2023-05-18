// 1557. Minimum Number of Vertices to Reach All Nodes

class Solution {
    // private List<Integer> Indegree()
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // Approach 1 :
        List<Integer> ans = new ArrayList<>();
        int[] indeg = new int[n];
        for(int i=0; i<edges.size(); i++) {
            List<Integer> curr = edges.get(i);
            indeg[curr.get(1)]++;
        }

        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) ans.add(i);
        }
        return ans;
    }
}
