class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int sr=x;
        int sc=y;
        int er=x+k-1;
        int ec=y+k-1;

        while(sr<er){
            for(int j=sc;j<=ec;j++){
                int temp=grid[sr][j];
                grid[sr][j]=grid[er][j];
                grid[er][j]=temp;
            }
            sr++;
            er--;
        }
        return grid;
    }
}

// class Solution {
//     public void update(int mat[][]){
//         int n=mat.length;
//         for(int i=0;i<n/2;i++){
//             int temp[]=mat[i];
//             mat[i]=mat[n-i-1];
//             mat[n-i-1]=temp;
//         }
//     }
//     public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
//         int sr=x;
//         int sc=y;
//         int er=x+k-1;
//         int ec=y+k-1;

//         int temp[][]=new int[k][k];
//         int a=0;
//         int b=0;
//         for(int i=sr;i<=er;i++){
//             b=0;
//             for(int j=sc;j<=ec;j++){
//                 temp[a][b]=grid[i][j];
//                 b++;
//             }
//             a++;
//         }

//         update(temp);
//         a=0;
//         b=0;
//         for(int i=sr;i<=er;i++){
//             b=0;
//             for(int j=sc;j<=ec;j++){
//                 grid[i][j]=temp[a][b];
//                 b++;
//             }
//             a++;
//         }
//         return grid;



//     }
// }