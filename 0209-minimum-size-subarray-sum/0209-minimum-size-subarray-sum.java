class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int sum=0;
        int left=0;
        int minLen=Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            sum=sum+nums[right];
            while(sum>=target){
                minLen=Math.min(minLen,right-left+1);
                sum=sum-nums[left];
                left++;
            }

        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}

// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int n=nums.length;
//         int left=0;
//         int sum=0;
//         int minLen=Integer.MAX_VALUE;
//         for(int right=0;right<n;right++){
//             sum=sum+nums[right];
//             while(sum>=target){
//                 minLen=Math.min(minLen,right-left+1);
//                 sum=sum-nums[left];
//                 left++;
//             }
//         }
//         return minLen==Integer.MAX_VALUE?0:minLen;
//     }
// }

// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int i=0;
//         int j=0;
//         int sum=0;
//         int len=Integer.MAX_VALUE;
//         while(j<nums.length && i<=j){
//             sum+=nums[j];
//             while(sum>=target){
//                 len=Math.min(j-i+1,len);
//                 sum-=nums[i];
//                 i++;
//             }
//             j++;
//         }
//         return len==Integer.MAX_VALUE?0:len;
//     }
// }