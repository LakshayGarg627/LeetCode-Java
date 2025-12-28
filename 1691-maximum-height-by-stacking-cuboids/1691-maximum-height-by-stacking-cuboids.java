class Solution {
    public int maxHeight(int[][] cuboids) {
        int n=cuboids.length;
        for(int cube[]:cuboids){
            Arrays.sort(cube);
        }
        Arrays.sort(cuboids,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            else if(a[1]!=b[1])return a[1]-b[1];
            else return a[2]-b[2];
        }
        );

        int dp[]=new int[n];
        int res=0;
        for(int i=0;i<n;i++){
            dp[i]=cuboids[i][2];
            res=Math.max(res,dp[i]);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(cuboids[j][0]<=cuboids[i][0] && cuboids[j][1]<=cuboids[i][1] && cuboids[j][2]<=cuboids[i][2]){
                    dp[i]=Math.max(dp[i],dp[j]+cuboids[i][2]);
                    res=Math.max(res,dp[i]);
                }
            }
        }
        return res;
    }
}

// class Solution {
//     public int maxHeight(int[][] cuboids) {
//         int n=cuboids.length;
//         for(int[] cube:cuboids){
//             Arrays.sort(cube);
//         }
//         Arrays.sort(cuboids,(a,b)->{
//             if(a[0]!=b[0]) return a[0]-b[0];
//             if(a[1]!=b[1]) return a[1]-b[1];
//             else return a[2]-b[2];
//         });
//         int res=0;
//         int dp[]=new int[n];
//         for(int i=0;i<n;i++){
//             dp[i]=cuboids[i][2];
//             res=Math.max(res,dp[i]);
//         }
//         for(int i=1;i<n;i++){
//             for(int j=0;j<i;j++){
//                 if(cuboids[j][0]<=cuboids[i][0] && cuboids[j][1]<=cuboids[i][1] &&cuboids[j][2]<=cuboids[i][2] ){
//                     dp[i]=Math.max(dp[i],dp[j]+cuboids[i][2]);
//                     res=Math.max(res,dp[i]);
//                 }
//             }
//         }
//         return res;
//     }
// }