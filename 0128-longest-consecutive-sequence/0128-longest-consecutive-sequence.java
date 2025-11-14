class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int maxCount=1;
        int count=1;
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]){
                count++;
            }
            else if(nums[i]==nums[i+1]){
                continue;
            }
            else{
                maxCount=Math.max(count,maxCount);
                count=1;
            }
        }
        maxCount=Math.max(count,maxCount);
        return maxCount;
    }
}