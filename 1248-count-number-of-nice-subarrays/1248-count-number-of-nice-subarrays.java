class Solution {
    public int helper(int nums[],int k){
        int n=nums.length;
        int odd=0;
        int count=0;
        int left=0;
        for(int right=0;right<n;right++){
            int ele=nums[right];
            if(ele%2!=0){
                odd++;
            }
            while(odd>k){
                int toremove=nums[left];
                if(toremove%2!=0){
                    odd--;
                }
               
                left++;
            }
            count+=(right-left+1);
            
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
}