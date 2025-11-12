class Solution {
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public int minOperations(int[] nums) {
        int n=nums.length;
        int check=nums[0];
        for(int i=1;i<n;i++){
            check=gcd(check,nums[i]);
        }
        if(check>1){
            return -1;
        }
        int ones=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                ones++;
            }
        }
        if(ones>0){
            return n-ones;
        }
        int count=0;
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int curr=nums[i];
            for(int j=i+1;j<n;j++){
                curr=gcd(curr,nums[j]);
                if(curr==1){
                    minLen=Math.min(minLen,j-i+1);
                    break;
                }
            }
        }
        if(minLen==Integer.MAX_VALUE){
            return -1;
        }

        count=(minLen-1)+(n-1);
        return count;

    }
}