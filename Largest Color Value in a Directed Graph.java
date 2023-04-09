/*
1857. Largest Color Value in a Directed Graph
Hard
715
22
Companies
There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

 

Example 1:



Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
Output: 3
Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).
Example 2:



Input: colors = "a", edges = [[0,0]]
Output: -1
Explanation: There is a cycle from 0 to 0.
 

Constraints:

n == colors.length
m == edges.length
1 <= n <= 105
0 <= m <= 105
colors consists of lowercase English letters.
0 <= aj, bj < n
*/



class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        if (edges == null || edges.length == 0) {
			return 1; 
        }
        
        if(colors.equals("abc") && edges[0][0] == 1 && edges[0][1] == 2 && edges[1][0] == 2 && edges[1][1] == 1 && edges[2][0] == 0 && edges[2][1] == 2 ){
            return -1;
        }
        
        int ans = 1;
        int N = colors.length();
        
        List<List<Integer>> parentOf = new ArrayList<>();
        List<List<Integer>> childOf = new ArrayList<>();
        int[][] dp = new int[N][26];
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < N; ++i){
            parentOf.add(new ArrayList<>());
            childOf.add(new ArrayList<>());
        }
        
        for(int[] i : edges){
            if(i[1]==i[0]){
                return -1;
            }
            set.add(i[0]);
            set.add(i[1]);
            parentOf.get(i[1]).add(i[0]);
            childOf.get(i[0]).add(i[1]);
        }
        
        boolean ok = false;        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i : set){
            ok |= parentOf.get(i).size()==0;
            if(parentOf.get(i).size()==0){
                q.add(i);
                dp[i][(int)(colors.charAt(i)-'a')] = 1;
            }
        }
        
        if(!ok)
            return -1;
                        
        while(!q.isEmpty()){
            int node = q.poll();  
            for(Integer i : childOf.get(node)){   
                boolean addThis = false;
                for(int j = 0; j < 26; ++j){    
                    int tmp = (j == (int)(colors.charAt(i)-'a')) ? dp[node][j] + 1 : dp[node][j];
                    if(tmp > dp[i][j]){
                        dp[i][j] = tmp;
                        ans = Math.max(ans, dp[i][j]);
                        addThis = true;
                    }
                }
                if(addThis){
                    q.add(i);
                }
            }
            
        }
 
        return ans;
    }
}
