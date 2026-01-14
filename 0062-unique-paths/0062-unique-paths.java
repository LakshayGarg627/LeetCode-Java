class Solution {
    public int count(int grid[][],int i,int j,int m,int n,int dp[][]){
        if(i<0 || i>=m || j<0 || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int right=count(grid,i+1,j,m,n,dp);
        int down=count(grid,i,j+1,m,n,dp);

        dp[i][j]=right+down;
        return dp[i][j];

    }
    public int uniquePaths(int m, int n) {
        int grid[][]=new int[m][n];
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return count(grid,0,0,m,n,dp);
    }
}

// class Solution {
//     public int count(int m,int n,int grid[][],int i,int j,int dp[][]){
//         if(i==m-1 && j==n-1){
//             return 1;
//         }
//         if(i<0 || i>=m || j<0 || j>=n){
//             return 0;
//         }
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         int bottom=count(m,n,grid,i+1,j,dp);
//         int right=count(m,n,grid,i,j+1,dp);

//         dp[i][j]=bottom+right;

//         return dp[i][j];


//     }
//     public int uniquePaths(int m, int n) {
//         int grid[][]=new int[m][n];
//         int dp[][]=new int[m][n];
//         for(int i=0;i<m;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return count(m,n,grid,0,0,dp);

//     }
// }