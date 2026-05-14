class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        
        Arrays.sort(nums);
        int max=nums[n-1];
        int targetSize=max+1;
        if(targetSize==n){
            int count=0;
            for(int i=n-1;i>=0;i--){
                if(nums[i]==max){
                    count++;
                }else{
                    break;
                }
            }
            if(count==2){
                for(int i=0;i<n-3;i++){
                    if(nums[i]>=nums[i+1]){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }else{
            return false;
        }
    }
}