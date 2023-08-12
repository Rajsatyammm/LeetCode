// //top down appraoch
// class Solution {
    
//     int[][] g;
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int[][] ans = new int[m][n];
//         ans[0][0]=1;
//         for(int i=0;i<m;i++)
//         {
//             for(int j=0;j<n;j++)
//             {
//                 if(j>0 && ans[i][j-1]!=-1 ) ans[i][j]=ans[i][j-1];
//                 if(i>0 && ans[i-1][j]!=-1) ans[i][j]+=ans[i-1][j];
//                 if(obstacleGrid[i][j]==1) ans[i][j]=0;
//             }
//         }
//         return ans[m-1][n-1];
//     }
//  }


//recursion with memoization
class Solution {
    int[][] ans;
    int[][] g;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        ans = new int[m][n];
        for(int[] a:ans)
        Arrays.fill(a,-1);
        this.g=obstacleGrid;
        
        return rec(m-1,n-1);
    }
    int rec(int i, int j)
    {
        
        if(i<0 || j<0 || g[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(ans[i][j]!=-1) return ans[i][j];
        else
        {
            int up= rec(i,j-1);
            int left = rec(i-1,j);
            ans[i][j]= up+left;
            return ans[i][j];
        }
    }
}