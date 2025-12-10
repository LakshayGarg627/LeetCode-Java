class Solution {
    public int helper(int grid[][],int i,int j,int n,int m,int dp[][]){
        if(i>=n || j>=m ){
            return 0;
        }
        if(i==n-1 && j==m-1 && grid[i][j]!=1){
            return 1;
        }
        if(grid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans1=helper(grid,i+1,j,n,m,dp);
        int ans2=helper(grid,i,j+1,n,m,dp);

        dp[i][j]= ans1+ans2;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(obstacleGrid,0,0,n,m,dp);
    }
}