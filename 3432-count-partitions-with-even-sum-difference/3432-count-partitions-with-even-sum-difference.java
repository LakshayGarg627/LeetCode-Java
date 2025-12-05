class Solution {
    public int sum(List<Integer> temp){
        int sum=0;
        for(int i=0;i<temp.size();i++){
            sum+=temp.get(i);
        }
        return sum;
    }
    public int sum1(int nums[]){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;
    }
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int count=0;
        int total=sum1(nums);
        int newSum=0;
        for(int i=0;i<nums.length-1;i++){
            newSum+=nums[i];
            total=total-nums[i];
            if((total-newSum)%2==0){
                count++;
            }
        }
        return count;
    }
}