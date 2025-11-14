class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0 || n==1){
            return n;
        }
        Arrays.sort(nums);
        int maxCount=1;
        int count=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]+1==nums[i+1]){
                count++;
            }
            else if(nums[i]==nums[i+1]){
                continue;
            }else{
                maxCount=Math.max(count,maxCount);
                count=1;
            }
        }
        maxCount=Math.max(count,maxCount);
        return maxCount;
    }
}