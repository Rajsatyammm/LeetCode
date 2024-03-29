//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution{
    static HashMap<Integer,Integer> hm = new HashMap<>();
    public int largestIsland(int n,int[][] grid) 
    {
        // code here
        int key = 2;
        boolean vis[][] = new boolean [n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    int count = dfs(i, j, grid, key, vis, n);
                    hm.put(key++, count);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){

                    int d = (i+1 < n) ? grid[i+1][j] : 0;
                    int u = (i-1 >= 0) ? grid[i-1][j] : 0;
                    int l = (j-1 >= 0) ? grid[i][j-1] : 0;
                    int r = (j+1 < n) ? grid[i][j+1] : 0;

                    Set<Integer> set = new HashSet<>();
                    set.add(d); 
                    set.add(u); 
                    set.add(l); 
                    set.add(r);
                    int res = 1;
                    for(int val : set){
                        res = res + hm.getOrDefault(val, 0);
                    }
                    ans = Math.max(ans, res);
                }
            }
        }
        if(ans == 0) return n * n;
        return ans;
    }

    static int dfs(int i, int j, int[][] grid, int key, boolean vis[][], int n){
        if(i<0 || j<0 || i>=n ||j>=n || grid[i][j]==0 || vis[i][j]) return 0;
        vis[i][j] = true;
        grid[i][j] = key;
        int count = 1+dfs(i+1, j, grid, key, vis, n) + dfs(i-1, j, grid, key, vis, n) + 
            dfs(i, j+1, grid, key, vis, n) + dfs(i, j-1, grid, key, vis, n);
        return count;
    }
}
