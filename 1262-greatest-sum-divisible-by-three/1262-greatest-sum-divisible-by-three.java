class Solution {
    public int sum(int nums[],int idx,int dp[][],int n,int rem){
        if(idx==n){
            return rem==0?0:Integer.MIN_VALUE;
        }
        if(dp[idx][rem]!=-1){
            return dp[idx][rem];
        }
        int one=sum(nums,idx+1,dp,n,rem);

        int newRem=(rem+nums[idx])%3;
        int two=nums[idx]+sum(nums,idx+1,dp,n,newRem);



        return dp[idx][rem]=Math.max(one,two);

    }
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][3];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return sum(nums,0,dp,nums.length,0);

    }
}