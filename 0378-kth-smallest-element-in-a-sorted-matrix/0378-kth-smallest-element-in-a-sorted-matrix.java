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