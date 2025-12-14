class Solution {
    Integer dp[];
    public int helper(int nums[],int target){
        if(target==0){
            return 1;
        }
        if(target<0){
            return 0;
        }
        if(dp[target]!=null){
            return dp[target];
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=helper(nums,target-nums[i]);
        }

        dp[target]=count;
        return count;
    
    }
    public int combinationSum4(int[] nums, int target) {
        dp=new Integer[target+1];
        return helper(nums,target);
    }
}