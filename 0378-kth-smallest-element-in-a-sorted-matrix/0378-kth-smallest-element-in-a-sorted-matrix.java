// class Solution {
//     public int countlessThank(int matrix[][],int mid){
//         int n=matrix.length;
//         int col=n-1;
//         int count=0;
//         for(int row=0;row<n;row++){
//             while(col>=0 && matrix[row][col]>mid){
//                 col--;
//             }
//             count+=(col+1);
//         }
//         return count;
//     }
//     public int kthSmallest(int[][] matrix, int k) {
//         int n=matrix.length;
//         int low=matrix[0][0];
//         int high=matrix[n-1][n-1];
//         while(low<=high){
//             int mid=low+(high-low)/2;
//             int count=countlessThank(matrix,mid);
//             if(count<k){
//                 low=mid+1;
//             }else{
//                 high=mid-1;
//             }
//         }
//         return low;
//     }
// }

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pq.add(matrix[i][j]);
            }
        }
        while(k>1){
            int curr=pq.poll();
            k--;
        }
        return pq.poll();
    }
}