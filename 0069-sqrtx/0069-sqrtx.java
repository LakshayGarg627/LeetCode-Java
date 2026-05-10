class Solution {
    public int mySqrt(int x) {
        if(x==1 || x==0){
            return x;
        }
        int low=1;
        int high=x/2;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            long sq=(long)mid*mid;
            if(sq==x){
                return mid;
            }else if(sq>x){
                high=mid-1;
            }else{
                ans=mid;
                low=mid+1;
            }
        }
        return ans;
    }
}