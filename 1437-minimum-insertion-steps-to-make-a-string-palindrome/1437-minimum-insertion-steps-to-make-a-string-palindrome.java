class Solution {
    public int lps(String s1,String s2,int n,int m,int dp[][]){
        if(n<0 || m<0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n)==s2.charAt(m)){
            dp[n][m]=lps(s1,s2,n-1,m-1,dp)+1;
        }
        else{
            int ans1=lps(s1,s2,n-1,m,dp);
            int ans2=lps(s1,s2,n,m-1,dp);
            dp[n][m]=Math.max(ans1,ans2);
        }
        return dp[n][m];
    }
    public int tab(String s1,String s2){
        int n=s1.length();
        int dp[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    public int minInsertions(String s) {
        int n=s.length();
        // int dp[][]=new int[n+1][n+1];
        // for(int i=0;i<n+1;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        String temp=new StringBuilder(s).reverse().toString();
        // return s.length()-lps(s,temp,n-1,n-1,dp);
        return n-tab(s,temp);
    }
}