class Solution {
    public boolean isSafe(List<List<String>> board,int row,int col){
        for(int i=row-1;i>=0;i--){
            if(board.get(i).get(col).equals("Q")){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0; i--,j--){
            if(board.get(i).get(j).equals("Q")){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.size(); i--,j++){
            if(board.get(i).get(j).equals("Q")){
                return false;
            }
        }
        return true;
    }
    public void nqueens(List<List<String>> board,List<List<String>> result,int row){
        if(row==board.size()){
            printSol(board,result);
            return;
        }
        for(int j=0;j<board.get(row).size();j++){
            if(isSafe(board,row,j)){
                board.get(row).set(j,"Q");
                nqueens(board,result,row+1);
                board.get(row).set(j,".");
            }
        }
    }
    public void printSol(List<List<String>> board,List<List<String>> result){
        List<String> temp=new ArrayList<>();
        for(int i=0;i<board.size();i++){
            StringBuilder sb=new StringBuilder("");
            for(int j=0;j<board.get(i).size();j++){
                sb.append(board.get(i).get(j));
            }
            temp.add(sb.toString());
        }
        result.add(temp);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board=new ArrayList<>();
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<String> temp=new ArrayList<>();
            for(int j=0;j<n;j++){
                temp.add(".");
            }
            board.add(temp);
        }
        nqueens(board,result,0);
        return result;
    }
}


// class Solution {
//     public boolean issafe(List<List<String>> board,int row,int col){
//         // vertical up
//         for(int i=row-1;i>=0;i--){
//             if(board.get(i).get(col).equals("Q")){
//                 return false;
//             }
//         }
//         // left diagonal
//         for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
//             if(board.get(i).get(j).equals("Q")){
//                 return false;
//             }
//         }
//         // right diagonal
//         for(int i=row-1,j=col+1;i>=0 && j<board.size();i--,j++){
//             if(board.get(i).get(j).equals("Q")){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public void nqueens(List<List<String>> board,int row,List<List<String>> result){
//         if(row==board.size()){
//             print(board,result);
//             return;
//         }
//         for(int j=0;j<board.size();j++){
//            if(issafe(board,row,j)){
//              board.get(row).set(j,"Q");
//              nqueens(board,row+1,result);
//              board.get(row).set(j,".");
//            }
//         }
//     }
//     public void print(List<List<String>> board,List<List<String>> result){
//         List<String> temp=new ArrayList<>();
//         for(int i=0;i<board.size();i++){
//             StringBuilder rowStr = new StringBuilder();
//                 for (int j = 0; j < board.get(i).size(); j++) {
//                     rowStr.append(board.get(i).get(j)); // Convert row to string
//                 }
//             temp.add(rowStr.toString());
//         }
//         result.add(temp);
//     }
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> result=new ArrayList<>();
//         List<List<String>> board=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             List<String> temp=new ArrayList<>();
//             for(int j=0;j<n;j++){
//                 temp.add(".");
//             }
//             board.add(temp);
//         }
//         nqueens(board,0,result);
//         return result;
//     }
// }