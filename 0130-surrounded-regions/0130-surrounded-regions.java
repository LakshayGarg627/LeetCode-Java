class Solution {
    public void change(char[][] board,int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]!='O'){
            return;
        }
        board[i][j]='#';
        change(board,i+1,j,n,m);
        change(board,i-1,j,n,m);
        change(board,i,j+1,n,m);
        change(board,i,j-1,n,m);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j]=='O'){
                        change(board,i,j,n,m);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
        
    }
}