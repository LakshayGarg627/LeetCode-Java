class Solution {
    static long mod=1000000007;
    public long count(int grid[][],int k,int n,int m,int i,int j,long dp[][][],int xor){
        if(i<0 || i>=n || j<0 || j>=m){
            return 0;
        }
        xor^=grid[i][j];
        if(i==n-1 && j==m-1){
            if(xor==k){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[i][j][xor]!=-1){
            return dp[i][j][xor];
        }
        long bottom=count(grid,k,n,m,i+1,j,dp,xor);
        long right=count(grid,k,n,m,i,j+1,dp,xor);

        dp[i][j][xor]=(bottom+right)%mod;
        return dp[i][j][xor];
    }
    public int countPathsWithXorValue(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        long dp[][][]=new long[n][m][16];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return (int)(count(grid,k,n,m,0,0,dp,0)%mod);

    }
}