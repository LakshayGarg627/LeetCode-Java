class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int count=0;
        double sum=0;
        for(int i=0;i<k;i++){
            sum=sum+arr[i];
        }
        if((sum/k)>=threshold){
            count++;
        }
        for(int i=1;i<=n-k;i++){
            int toRemove=arr[i-1];
            int toAdd=arr[i+k-1];

            sum=sum-toRemove;
            sum=sum+toAdd;

            if((sum/k)>=threshold){
                count++;
            }
            
        }
        return count;
    }
}