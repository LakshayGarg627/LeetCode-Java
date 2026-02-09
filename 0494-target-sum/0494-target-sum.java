class Solution {
    static int offset;
    public int helper(int nums[],int target,int n,int idx,int result,int dp[][]){
        if(idx==n){
            return result==target?1:0;
        }
        if(dp[idx][result+offset]!=-1){
            return dp[idx][result+offset];
        }
        int way1=helper(nums,target,n,idx+1,result+nums[idx],dp);
        int way2=helper(nums,target,n,idx+1,result-nums[idx],dp);

        dp[idx][result+offset] = way1+way2;
        return dp[idx][result+offset];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int n=nums.length;
        int dp[][]=new int[n+1][2*sum+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        offset=sum;
        return helper(nums,target,n,0,0,dp);
    }
}