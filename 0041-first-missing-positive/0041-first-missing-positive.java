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

        System.out.println(Arrays.toString(nums));

        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return n+1;

    }
}