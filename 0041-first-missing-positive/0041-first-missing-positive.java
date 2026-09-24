// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         for(int i=0;i<nums.length;i++){
//             while(nums[i]>0 && nums[i]<nums.length && nums[i]!=nums[nums[i]-1]){
//                 int temp=nums[i];
//                 nums[i]=nums[temp-1];
//                 nums[temp-1]=temp;
//             }
//         }
//         for(int i=0;i<nums.length;i++){
//             if(i+1!=nums[i]){
//                 return i+1;
//             }
//         }
//         return nums.length+1;

//     }
// }

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n){
            int corrPos=nums[i]-1;
            if(nums[i]>0 && nums[i]<=n && nums[i]!=nums[corrPos]){
                int temp=nums[i];
                nums[i]=nums[corrPos];
                nums[corrPos]=temp;
            }else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return n+1;

    }
}