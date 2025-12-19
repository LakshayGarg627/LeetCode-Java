class Solution {
    public int helper(int dp[],int n){
        if(n==0 || n==1){
            return n;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=helper(dp,n-1)+helper(dp,n-2);

        return dp[n];
    }
    public int fib(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(dp,n);
    }
}