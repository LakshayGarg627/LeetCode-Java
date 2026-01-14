class Solution {
    public boolean helper(int arr[],int idx,int n,Boolean dp[]){
        if(idx<0 || idx>=n){
            return false;
        }
        if(arr[idx]==0){
            return true;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        dp[idx]=false;
        boolean way1=helper(arr,idx-arr[idx],n,dp);
        boolean way2=helper(arr,idx+arr[idx],n,dp);

        dp[idx]= way1 || way2;
        return dp[idx];
    }
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Boolean dp[]=new Boolean[n];
        return helper(arr,start,n,dp);
    }
}