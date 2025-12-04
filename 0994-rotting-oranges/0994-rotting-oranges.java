class Solution {
    class Info{
        int x;
        int y;
        int time;
        Info(int x,int y,int time){
            this.x=x;
            this.y=y;
            this.time=time;
        }
    }
    public boolean isValid(int i,int j,int n,int m){
        return i>=0 && i<n && j>=0 && j<m; 
    }
    public int calculate(int grid[][],int n,int m,boolean visited[][]){
        Queue<Info> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Info(i,j,0));
                    visited[i][j]=true;
                }
            }
        }
        int minTime=0;
        while(!q.isEmpty()){
            Info curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            int time=curr.time;
            minTime=Math.max(time,minTime);

            if(isValid(x+1,y,n,m) && grid[x+1][y]==1 && !visited[x+1][y]){
                grid[x+1][y]=2;
                visited[x+1][y]=true;
                q.add(new Info(x+1,y,time+1));
            }
            if(isValid(x-1,y,n,m) && grid[x-1][y]==1 && !visited[x-1][y]){
                grid[x-1][y]=2;
                visited[x-1][y]=true;
                q.add(new Info(x-1,y,time+1));
            }
            if(isValid(x,y+1,n,m) && grid[x][y+1]==1 && !visited[x][y+1]){
                grid[x][y+1]=2;
                visited[x][y+1]=true;
                q.add(new Info(x,y+1,time+1));
            }
            if(isValid(x,y-1,n,m) && grid[x][y-1]==1 && !visited[x][y-1]){
                grid[x][y-1]=2;
                visited[x][y-1]=true;
                q.add(new Info(x,y-1,time+1));
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return minTime;
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        int rotten=calculate(grid,n,m,visited);
        return rotten;
    }
}

// class Solution {
//     class Info{
//         int x;
//         int y;
//         int time;
//         Info(int x,int y,int time){
//             this.x=x;
//             this.y=y;
//             this.time=time;
//         }
//     }
//     public boolean isValid(int i,int j,int n,int m){
//         return i>=0 && i<n && j>=0 && j<m;
//     }
//     public int oranges(int grid[][],int n,int m,boolean visited[][]){
//         Queue<Info> q=new LinkedList<>();
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(!visited[i][j] && grid[i][j]==2){
//                     q.add(new Info(i,j,0));
//                     visited[i][j]=true;
//                 }
//             }
//         }
//         int mintime=0;
//         while(!q.isEmpty()){
//             Info curr=q.remove();
//             int currX=curr.x;
//             int currY=curr.y;
            
//             int time=curr.time;
//             mintime=Math.max(time,mintime);
//             if(isValid(currX+1,currY,n,m) && grid[currX+1][currY]==1 && !visited[currX+1][currY]){
//                 grid[currX+1][currY]=2;
//                 visited[currX+1][currY]=true;
//                 q.add(new Info(currX+1,currY,time+1));
//             }
//             if(isValid(currX-1,currY,n,m) && grid[currX-1][currY]==1 && !visited[currX-1][currY]){
//                 grid[currX-1][currY]=2;
//                 visited[currX-1][currY]=true;
//                 q.add(new Info(currX-1,currY,time+1));
//             }
//             if(isValid(currX,currY+1,n,m) && grid[currX][currY+1]==1 && !visited[currX][currY+1]){
//                 grid[currX][currY+1]=2;
//                 visited[currX][currY+1]=true;
//                 q.add(new Info(currX,currY+1,time+1));
//             }
//             if(isValid(currX,currY-1,n,m) && grid[currX][currY-1]==1 && !visited[currX][currY-1]){
//                 grid[currX][currY-1]=2;
//                 visited[currX][currY-1]=true;
//                 q.add(new Info(currX,currY-1,time+1));
//             }

//         }
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]==1){
//                     return -1;
//                 }
//             }
//         }
//         return mintime;
//     }
//     public int orangesRotting(int[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;
//         boolean visited[][]=new boolean[n][m];
//         int rotten=oranges(grid,n,m,visited);
//         return rotten;
        
//     }
// }