class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int maxIdx=-1;
        int minIdx=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                max=nums[i];
                maxIdx=i;
            }
            if(min>nums[i]){
                min=nums[i];
                minIdx=i;
            }
        }
        int left=Math.min(maxIdx,minIdx);
        int right=Math.max(maxIdx,minIdx);

        int ans1=right+1;
        int ans2=n-left;
        int ans3=(left+1)+(n-right);
        

        return Math.min(ans1,Math.min(ans2,ans3));

    }
}