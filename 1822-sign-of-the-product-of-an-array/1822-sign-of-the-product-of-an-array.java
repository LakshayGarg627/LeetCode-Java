class Solution {
    public int arraySign(int[] nums) {
        int n=nums.length;
        int neg=0;
        int zero=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero++;
            }
            if(nums[i]<0){
                neg++;
            }
        }
        if(zero>0){
            return 0;
        }
        if(neg%2!=0){
            return -1;
        }
        return 1;

    }
}