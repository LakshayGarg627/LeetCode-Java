class Solution {
    public int num(int grid[][],int n,int m,int i,int j,int k,int dp[][][],int sum){
        if(i>=n || i<0 || j>=m || j<0){
            return 0;
        }
        sum=((sum+grid[i][j])%k);
        if(i==n-1 && j==m-1){
            return sum==0?1:0;
        }
        if(dp[i][j][sum]!=-1){
            return dp[i][j][sum];
        }
        int right=num(grid,n,m,i,j+1,k,dp,sum);
        int bottom=num(grid,n,m,i+1,j,k,dp,sum);

        dp[i][j][sum]=(right+bottom)%1000000007;
        return dp[i][j][sum];
    }
    public int numberOfPaths(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][][]=new int[n][m][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return num(grid,n,m,0,0,k,dp,0);
    }
}