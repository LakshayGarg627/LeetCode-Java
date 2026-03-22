class Solution {
    public boolean isEqual(int mat1[][],int mat2[][]){
        int n=mat1.length;
        int m=mat1[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat1[i][j]!=mat2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public void rotate(int mat[][]){
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n/2;i++){
            int temp[]=mat[i];
            mat[i]=mat[n-i-1];
            mat[n-i-1]=temp;          
        }
        int trans[][]=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                trans[i][j]=mat[j][i];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=trans[i][j];
            }
        }

    }
    public boolean findRotation(int[][] mat, int[][] target) {
        if(mat.length!=target.length || mat[0].length != target[0].length){
            return false;
        }
        int i=4;
        while(i>0){
            if(isEqual(mat,target)){
                return true;
            }
            rotate(mat);
            i--;
        }
        return false;
    }
}

// class Solution {
//     public boolean isEqual(int mat1[][],int mat2[][]){
//         int n=mat1.length;
//         int m=mat1[0].length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(mat1[i][j]!=mat2[i][j]){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public void rotate(int mat[][]){
//         int n=mat.length;
//         int m=mat[0].length;
//         for(int i=0;i<n/2;i++){
//             int temp[]=mat[i];
//             mat[i]=mat[n-i-1];
//             mat[n-i-1]=temp;          
//         }
//         int trans[][]=new int[m][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 trans[i][j]=mat[j][i];
//             }
//         }
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 mat[i][j]=trans[i][j];
//             }
//         }

//     }
//     public boolean findRotation(int[][] mat, int[][] target) {
//         if(mat.length!=target.length || mat[0].length != target[0].length){
//             return false;
//         }
//         int n=mat.length;
//         int m=mat[0].length;

//         int copy[][]=new int[n][m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 copy[i][j]=mat[i][j];
//             }
//         }
//         boolean result=false;
//         while(true){
//             if(isEqual(mat,target)){
//                 result=true;
//                 break;
//             }
//             rotate(mat);
//             if(isEqual(mat,copy)){
//                 result=false;
//                 break;
//             }
//         }
//         return result;
//     }
// }