class Solution {
    public boolean isGood(int arr[],int n,int h,int mid){
        int totalTime=0;
        int current=mid;
        for(int i=0;i<n;i++){
            totalTime+=(Math.ceil((double)arr[i]/mid));
            if(totalTime>h){
                return false;
            }
        }
        return totalTime<=h;
    }
    public int max(int arr[]){
        int m=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(m<arr[i]){
                m=arr[i];
            }
        }
        return m;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1;
        int high=max(piles);
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isGood(piles,n,h,mid)){
                ans=Math.min(mid,ans);
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}