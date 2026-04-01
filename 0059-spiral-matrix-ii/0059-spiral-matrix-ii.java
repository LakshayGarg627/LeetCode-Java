class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        int ele=1;
        while(top<=bottom && left<=right){
            for(int j=left;j<=right;j++){
                matrix[top][j]=ele++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                matrix[i][right]=ele++;
            }
            right--;
            if(top<=bottom){
                for(int j=right;j>=left;j--){
                    matrix[bottom][j]=ele++;
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    matrix[i][left]=ele++;
                }
                left++;
            }
        }
        return matrix;

    }
}

// class Solution {
//     public int[][] generateMatrix(int n) {
//         int matrix[][]=new int[n][n];
//         int top=0;
//         int bottom=n-1;
//         int left=0;
//         int right=n-1;
//         int count=1;
//         while(top<=bottom && left<=right){
//             for(int j=left;j<=right;j++){
//                 matrix[top][j]=count;
//                 count++;
//             }
//             top++;
//             for(int i=top;i<=bottom;i++){
//                 matrix[i][right]=count;
//                 count++;
//             }
//             right--;
//             if(top<=bottom){
//                 for(int j=right;j>=left;j--){
//                     matrix[bottom][j]=count;
//                     count++;
//                 }
//                 bottom--;
//             }
//             if(left<=right){
//                 for(int i=bottom;i>=top;i--){
//                     matrix[i][left]=count;
//                     count++;
//                 }
//                 left++;
//             }
//         }
//         return matrix;
//     }
// }