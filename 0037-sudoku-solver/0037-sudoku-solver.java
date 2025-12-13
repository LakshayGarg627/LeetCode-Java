class Solution {
    public boolean isSafe(char board[][],int row,int col,int digit){
        for(int i=0;i<9;i++){
            if(board[i][col]==(char)(digit+'0')){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(board[row][j]==(char)(digit+'0')){
                return false;
            }
        }

        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==(char)(digit+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean sudoku(char board[][],int i,int j){
        // base
        if(i==9){
            return true;
        }

        int nextRow=i;
        int nextCol=j+1;
        if(j+1==9){
            nextRow=i+1;
            nextCol=0;
        }

        if(board[i][j]!='.'){
            return sudoku(board,nextRow,nextCol);
        }

        // recursion
        for(int digit=1;digit<=9;digit++){
            if(isSafe(board,i,j,digit)){
                board[i][j]=(char)(digit+'0');
                if(sudoku(board,nextRow,nextCol)){
                    return true;
                }
                board[i][j]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        sudoku(board,0,0);
    }
}

// class Solution {
//     public boolean isSafe(char board[][],int row,int col,int digit){
//         // col
//         for(int i=0;i<9;i++){
//             if(board[i][col]==(char)(digit+'0')){
//                 return false;
//             }
//         }
//         // row
//         for(int j=0;j<9;j++){
//             if(board[row][j]==(char)(digit+'0')){
//                 return false;
//             }
//         }
//         // BOX
//         int startRow=(row/3)*3;
//         int startCol=(col/3)*3;
//         for(int i=startRow;i<startRow+3;i++){
//             for(int j=startCol;j<startCol+3;j++){
//                 if(board[i][j]==(char)(digit+'0')){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean sudoku(char board[][],int row,int col){
//         if(row==9){
//             return true;
//         }
//         int nextRow=row;
//         int nextCol=col+1;
//         if(col+1==9){
//             nextRow=row+1;
//             nextCol=0;
//         }
//         if(board[row][col]!='.'){
//             return sudoku(board,nextRow,nextCol);
//         }
//         for(int digit=1;digit<=9;digit++){
//             if(isSafe(board,row,col,digit)){
//                 board[row][col]=(char)(digit+'0');
//                 if(sudoku(board,nextRow,nextCol)){
//                     return true;
//                 }
//                 board[row][col]='.';
//             }
//         }
//         return false;
//     }
//     public void solveSudoku(char[][] board) {
//         sudoku(board,0,0);
//     }
// }