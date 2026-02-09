class Solution {
    public int helper(int nums[],int target,int n,int idx,int result){
        if(idx==n){
            return result==target?1:0;
        }
        int way1=helper(nums,target,n,idx+1,result+nums[idx]);
        int way2=helper(nums,target,n,idx+1,result-nums[idx]);

        return way1+way2;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return helper(nums,target,n,0,0);
    }
}