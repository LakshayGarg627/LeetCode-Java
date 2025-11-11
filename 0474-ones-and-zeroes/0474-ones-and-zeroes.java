class Solution {
    public int helper(String str[],int m,int n,int i,int dp[][][]){
        if(i==str.length){
            return 0;
        }
        if(dp[i][m][n]!=-1){
            return dp[i][m][n];
        }
        int zeroes=0;
        int ones=0;
        for(int j=0;j<str[i].length();j++){
            if(str[i].charAt(j)=='0'){
                zeroes++;
            }else{
                ones++;
            }
        }
        int nottake=helper(str,m,n,i+1,dp);
        int take=0;
        if(zeroes<=m && ones<=n){
            take=1+helper(str,m-zeroes,n-ones,i+1,dp);
        }
        dp[i][m][n]=Math.max(take,nottake);
        return dp[i][m][n];
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int dp[][][]=new int[len][m+1][n+1];
        for(int i=0;i<len;i++){
            for(int j=0;j<m+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(strs,m,n,0,dp);

    }
}