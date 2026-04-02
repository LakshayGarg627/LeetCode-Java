class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        double sum=0;
        for(int i=0;i<k;i++){
            sum=sum+arr[i];
        }
        int count=0;
        double avg=sum/k;

        if(avg>=threshold){
            count++;
        }
        for(int i=1;i<n-k+1;i++){
            int include=arr[i+k-1];
            int exclude=arr[i-1];

            sum=sum-exclude;
            sum=sum+include;

            avg=sum/k;

            if(avg>=threshold){
                count++;
            }
        }
        return count;
    }
}

// class Solution {
//     public int numOfSubarrays(int[] arr, int k, int threshold) {
//         int n=arr.length;
//         double sum=0;
//         int count=0;
//         for(int i=0;i<k;i++){
//             sum=sum+arr[i];
//         }
//         double avg=sum/k;
//         if(avg>=threshold){
//             count++;
//         }
//         for(int i=1;i<=n-k;i++){
//             int exclude=arr[i-1];
//             int include=arr[i+k-1];

//             sum=sum-exclude;
//             sum=sum+include;

//             avg=sum/k;
//             if(avg>=threshold){
//                 count++;
//             }
//         }
//         return count;
//     }
// }