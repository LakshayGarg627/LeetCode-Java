class Solution {
    public int helper(int coins[],int amount,int n,int dp[][]){
        if(n==0){
            return Integer.MAX_VALUE;
        }
        if(amount==0){
            return 0;
        }
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }
        if(coins[n-1]<=amount){
            int include=helper(coins,amount-coins[n-1],n,dp);
            if(include!=Integer.MAX_VALUE){
                include+=1;
            }
            int exclude=helper(coins,amount,n-1,dp);
            dp[n][amount]= Math.min(include,exclude);
        }else{
            int exclude=helper(coins,amount,n-1,dp);
            dp[n][amount]= exclude;
        }
        return dp[n][amount];


    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n+1][amount+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        int result=helper(coins,amount,n,dp);

        return (result>=Integer.MAX_VALUE-1)?-1:result;
    }   
}