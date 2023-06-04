class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                provinces++;
                dfs(isConnected, vis, i);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] vis, int curr) {
        vis[curr] = true;
        for (int dest = 0; dest < isConnected.length; dest++) {
            if (isConnected[curr][dest] == 1 && !vis[dest]) {
                dfs(isConnected, vis, dest);
            }
        }
    }
}