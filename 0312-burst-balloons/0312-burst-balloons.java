class Solution {
    public int helper(int nums[],int i,int j,int dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int left=helper(nums,i,k-1,dp);
            int right=helper(nums,k+1,j,dp);

            int currCost=nums[k];

            if(i-1>=0){
                currCost=currCost*nums[i-1];
            }
            if(j+1<nums.length){
                currCost=currCost*nums[j+1];
            }
            ans=Math.max(ans,left+right+currCost);
            dp[i][j]=ans;
        }
        return dp[i][j];
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(nums,0,n-1,dp);

    }
}

// class Solution {
//     public int helper(int nums[],int i,int j,int dp[][]){
//         if(i>j){
//             return 0;
//         }
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         int ans=Integer.MIN_VALUE;
//         for(int k=i;k<=j;k++){
//             int left=helper(nums,i,k-1,dp);
//             int right=helper(nums,k+1,j,dp);
//             int currcost=nums[k];
//             if(i-1>=0){
//                 currcost=currcost*nums[i-1];
//             }
//             if(j+1<nums.length){
//                 currcost=currcost*nums[j+1];
//             }
//             ans=Math.max(ans,left+right+currcost);
//             dp[i][j]=ans;
//         }
//         return dp[i][j];

        
//     }
//     public int maxCoins(int[] nums) {
//         int n=nums.length;
//         int dp[][]=new int[n+1][n+1];
//         for(int i=0;i<n+1;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return helper(nums,0,n-1,dp);
//     }
// }