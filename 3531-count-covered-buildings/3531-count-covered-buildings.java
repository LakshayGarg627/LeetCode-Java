class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        int[] leftmost = new int[n+1];
        int[] rightmost = new int[n+1];
        int[] topmost = new int[n+1];
        int[] bottommost = new int[n+1];

        // Initialize
        for(int i=1;i<=n;i++){
            leftmost[i] = Integer.MAX_VALUE;
            topmost[i] = Integer.MAX_VALUE;
        }

        // Build boundaries
        for(int[] b : buildings){
            int r = b[0];
            int c = b[1];

            leftmost[r] = Math.min(leftmost[r], c);
            rightmost[r] = Math.max(rightmost[r], c);

            topmost[c] = Math.min(topmost[c], r);
            bottommost[c] = Math.max(bottommost[c], r);
        }

        int count = 0;

        // Check each building
        for(int[] b : buildings){
            int r = b[0];
            int c = b[1];

            boolean hasLeft = leftmost[r] < c;
            boolean hasRight = rightmost[r] > c;
            boolean hasTop = topmost[c] < r;
            boolean hasBottom = bottommost[c] > r;

            if(hasLeft && hasRight && hasTop && hasBottom){
                count++;
            }
        }

        return count;
    }
}



// Time limit exceeded
// class Solution {
//     public boolean isTrue(HashSet<String> set,int i,int j,int n){
//         boolean top=false;
//         boolean bottom=false;
//         boolean left=false;
//         boolean right=false;
        
//         for(int a=i-1;a>=1;a--){
//             if(set.contains(a+","+j)){
//                 top=true;
//                 break;
//             }
//         }
        
//         for(int a=i+1;a<=n;a++){
//             if(set.contains(a+","+j)){
//                 bottom=true;
//                 break;
//             }
//         }
        
        
//         for(int a=j-1;a>=1;a--){
//             if(set.contains(i+","+a)){
//                 left=true;
//                 break;
//             }
//         }
        
//         for(int a=j+1;a<=n;a++){
//             if(set.contains(i+","+a)){
//                 right=true;
//                 break;
//             }
//         }
        

//         return top && bottom && left && right; 
//     }
//     public int countCoveredBuildings(int n, int[][] buildings) {
//         HashSet<String> set=new HashSet<>();
//         for(int i=0;i<buildings.length;i++){
//             int a=buildings[i][0];
//             int b=buildings[i][1];
//             set.add(a+","+b);
//         }
//         int count=0;
//         for(int i=0;i<buildings.length;i++){
//             int a=buildings[i][0];
//             int b=buildings[i][1];
//             if(isTrue(set,a,b,n)){
//                 count++;
//             }
//         }
//         return count;
//     }
// }

// MEMORY LIMIT EXCEEDED
// class Solution {
//     public boolean isTrue(int matrix[][],int i,int j,int n){
//         boolean top=false;
//         boolean bottom=false;
//         boolean left=false;
//         boolean right=false;
        
//         for(int a=i-1;a>=0;a--){
//             if(matrix[a][j]==1){
//                 top=true;
//                 break;
//             }
//         }
        
//         for(int a=i+1;a<n;a++){
//             if(matrix[a][j]==1){
//                 bottom=true;
//                 break;
//             }
//         }
        
        
//         for(int a=j-1;a>=0;a--){
//             if(matrix[i][a]==1){
//                 left=true;
//                 break;
//             }
//         }
        
//         for(int a=j+1;a<n;a++){
//             if(matrix[i][a]==1){
//                 right=true;
//                 break;
//             }
//         }
        

//         return top && bottom && left && right; 
//     }
//     public int countCoveredBuildings(int n, int[][] buildings) {
//         int matrix[][]=new int[n][n];
//         for(int i=0;i<buildings.length;i++){
//             int a=buildings[i][0];
//             int b=buildings[i][1];

//             matrix[a-1][b-1]=1;
//         }
//         int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(matrix[i][j]==1){
//                     if(isTrue(matrix,i,j,n)){
//                         count++;
//                     }
//                 }
//             }
//         }
//         return count;

//     }
// }