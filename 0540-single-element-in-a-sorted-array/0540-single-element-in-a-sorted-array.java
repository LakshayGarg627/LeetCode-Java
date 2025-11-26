class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid==0 && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(mid==n-1 && nums[n-1]!=nums[n-2]){
                return nums[n-1];
            }
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }

            if(mid%2==0){
                if(nums[mid]==nums[mid-1]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(nums[mid]==nums[mid-1]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}

// class Solution {
//     public int singleNonDuplicate(int[] nums) {
//         int n=nums.length;
//         if(n==1){
//             return nums[0];
//         }
//         if(nums[0]!=nums[1]){
//             return nums[0];
//         }
//         if(nums[n-1]!=nums[n-2]){
//             return nums[n-1];
//         }
//         for(int i=1;i<n-1;i++){
//             if(nums[i-1]!=nums[i] && nums[i]!=nums[i+1]){
//                 return nums[i];
//             }
//         }
//         return -1;
//     }
// }