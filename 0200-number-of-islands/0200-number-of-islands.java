class Solution {
    public void dfs(char grid[][],boolean visited[][],int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m || visited[i][j] || grid[i][j]=='0'){
            return;
        }
        visited[i][j]=true;
        dfs(grid,visited,i+1,j,n,m);
        dfs(grid,visited,i-1,j,n,m);
        dfs(grid,visited,i,j+1,n,m);
        dfs(grid,visited,i,j-1,n,m);
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid,visited,i,j,n,m);
                    count++;
                }
            }
        }
        return count;
    }
}

// class Solution {
//     public void dfs(char grid[][],boolean visited[][],int i,int j,int n,int m){
//         if(i<0 || i>=n || j<0 || j>=m || visited[i][j] || grid[i][j]!='1'){
//             return;
//         }
//         visited[i][j]=true;
//         dfs(grid,visited,i+1,j,n,m);
//         dfs(grid,visited,i-1,j,n,m);
//         dfs(grid,visited,i,j+1,n,m);
//         dfs(grid,visited,i,j-1,n,m);
//     }
//     public int numIslands(char[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;
//         boolean visited[][]=new boolean[n][m];
//         int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]=='1' && !visited[i][j]){
//                     dfs(grid,visited,i,j,n,m);
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

// DFS RECURSIVE APPROACH
// class Solution {
//     public void island(char grid[][],boolean visited[][],int i,int j,int n,int m){
//         if(i<0 || j<0 || i>=n || j>=m || grid[i][j]=='0' || visited[i][j]){
//             return;
//         }
//         visited[i][j]=true;
//         island(grid,visited,i+1,j,n,m);
//         island(grid,visited,i-1,j,n,m);
//         island(grid,visited,i,j+1,n,m);
//         island(grid,visited,i,j-1,n,m);
//     }
//     public int numIslands(char[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;

//         int count=0;
//         boolean visited[][]=new boolean[n][m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(!visited[i][j] && grid[i][j]=='1'){
//                     island(grid,visited,i,j,n,m);
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }

// DFS- ITERATIVE APPROACH 
// class Solution {
//     class Info{
//         int x;
//         int y;
//         Info(int x,int y){
//             this.x=x;
//             this.y=y;
//         }
//     }
//     public boolean isValid(int x,int y,int n,int m){
//         return x>=0 && x<n && y>=0 && y<m;
//     }
//     public void island(char grid[][],boolean visited[][],int i,int j,int n,int m)  {
//         Stack<Info> s=new Stack<>();
//         s.push(new Info(i,j));
        
//         while(!s.isEmpty()){
//             Info curr=s.pop();
//             int x=curr.x;
//             int y=curr.y;
//             visited[x][y]=true;
//             if(isValid(x+1,y,n,m) && grid[x+1][y]=='1' && !visited[x+1][y]){
//                 s.push(new Info(x+1,y));
//                 // visited[x+1][y]=true;
//             }
//             if(isValid(x-1,y,n,m) && grid[x-1][y]=='1' && !visited[x-1][y]){
//                 s.push(new Info(x-1,y));
//                 // visited[x-1][y]=true;
//             }
//             if(isValid(x,y+1,n,m) && grid[x][y+1]=='1' && !visited[x][y+1]){
//                 s.push(new Info(x,y+1));
//                 // visited[x][y+1]=true;
//             }
//             if(isValid(x,y-1,n,m) && grid[x][y-1]=='1' && !visited[x][y-1]){
//                 s.push(new Info(x,y-1));
//                 // visited[x][y-1]=true;
//             }
//         }
//     }
//     public int numIslands(char[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;

//         boolean visited[][]=new boolean[n][m];
//         int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(!visited[i][j] && grid[i][j]=='1'){
//                     island(grid,visited,i,j,n,m);
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }