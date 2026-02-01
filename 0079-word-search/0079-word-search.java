class Solution {
    public boolean dfs(char board[][],String word,boolean visited[][],int n,int m,int i,int j,int idx){
        if(i<0 || i>=n || j<0 || j>=m || visited[i][j] || word.charAt(idx)!=board[i][j]){
            return false;
        }
        if(idx==word.length()-1){
            return true;
        }
        visited[i][j]=true;
        boolean top=dfs(board,word,visited,n,m,i-1,j,idx+1);
        boolean bottom=dfs(board,word,visited,n,m,i+1,j,idx+1);
        boolean left=dfs(board,word,visited,n,m,i,j+1,idx+1);
        boolean right=dfs(board,word,visited,n,m,i,j-1,idx+1);
        visited[i][j]=false;
        return top || bottom || left || right;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && board[i][j]==word.charAt(0)){
                    if(dfs(board,word,visited,n,m,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// class Solution {
//     public boolean dfs(char board[][],int i,int j,int n,int m,boolean visited[][],String word,int idx){
//         if(idx==word.length()){
//             return true;
//         }
//         if(i<0 || i>=n || j<0 || j>=m || visited[i][j] || board[i][j]!=word.charAt(idx)){
//             return false;
//         }
//         visited[i][j]=true;
//         boolean top=dfs(board,i-1,j,n,m,visited,word,idx+1);
//         boolean bottom=dfs(board,i+1,j,n,m,visited,word,idx+1);
//         boolean left=dfs(board,i,j-1,n,m,visited,word,idx+1);
//         boolean right=dfs(board,i,j+1,n,m,visited,word,idx+1);
//         visited[i][j]=false;
//         if(top || bottom || left || right){
//             return true;
//         }
//         return false;
//     }
//     public boolean exist(char[][] board, String word) {
//         int n=board.length;
//         int m=board[0].length;

//         boolean visited[][]=new boolean[n+1][m+1];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(!visited[i][j] && board[i][j]==word.charAt(0)){
//                     if(dfs(board,i,j,n,m,visited,word,0)){
//                         return true;
//                     }
//                 }
//             }
//         }
//         return false;
//     }
// }

