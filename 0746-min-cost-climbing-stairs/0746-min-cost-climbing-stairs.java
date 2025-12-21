class Solution {
    public int helper(int cost[],int n,int idx,int dp[]){
        if(idx>=n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int way1=helper(cost,n,idx+1,dp);
        int way2=helper(cost,n,idx+2,dp);
        dp[idx]=cost[idx]+Math.min(way1,way2);

        return dp[idx];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost,n,0,dp),helper(cost,n,1,dp));
    }
}

// class Solution {
//     public int helper(int cost[],int dp[],int i){
//         if(i>=cost.length){
//             return 0;
//         }
//         if(dp[i]!=-1){
//             return dp[i];
//         }
//         int ans1=helper(cost,dp,i+1);
//         int ans2=helper(cost,dp,i+2);
//         dp[i]=cost[i]+Math.min(ans1,ans2);

//         return dp[i];
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n=cost.length;
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         return Math.min(helper(cost,dp,0),helper(cost,dp,1));
//     }
// }

// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n=cost.length;
//         int dp[]=new int[cost.length+2];
//         dp[n+1]=0;
//         dp[n]=0;
//         for(int i=n-1;i>=0;i--){
//             dp[i]=cost[i]+Math.min(dp[i+1],dp[i+2]);
//         }
//         return Math.min(dp[0],dp[1]);
//     }
// }

// MEMOIZATION
// class Solution {
//     public int helper(int cost[],int dp[],int i){
//         if(dp[i]!=-1){
//             return dp[i];
//         }
//         int jump1=helper(cost,dp,i+1);
//         int jump2=helper(cost,dp,i+2);

//         dp[i]=cost[i]+Math.min(jump1,jump2);
//         return dp[i];
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n=cost.length;
//         int dp[]=new int[n+2];
//         Arrays.fill(dp,-1);
//         dp[n]=dp[n+1]=0;
//         helper(cost,dp,0);
//         return Math.min(dp[0],dp[1]);

//     }
// }