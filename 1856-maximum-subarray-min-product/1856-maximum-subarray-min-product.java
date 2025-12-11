class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n=nums.length;
        long mod=1000000007;
        long prefix[]=new long[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        int nsl[]=new int[n];
        int nsr[]=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && nums[s.peek()]>=nums[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && nums[s.peek()]>=nums[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        long ans=0;
        for(int i=0;i<n;i++){
            int l=nsl[i];
            int r=nsr[i];
            long sum=prefix[r]-prefix[l+1];
            long product=sum*nums[i];

            ans=Math.max(ans,product); 
        }
        return (int)(ans%mod);

    }
}