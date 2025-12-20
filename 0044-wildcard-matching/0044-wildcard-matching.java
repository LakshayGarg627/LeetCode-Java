class Solution {
    public boolean helper(String s,String p,int n,int m,Boolean dp[][]){
        if(n==0 && m==0){
            return true;
        }
        if(m==0){
            return false;
        }
        if(n==0){
            for(int i=0;i<m;i++){
                if(p.charAt(i)!='*'){
                    dp[0][m]=false;
                    return false;
                }
                
            }
            dp[0][m]=true;
            return true;
        }
        if(dp[n][m]!=null){
            return dp[n][m];
        }
        if(s.charAt(n-1)==p.charAt(m-1) || p.charAt(m-1)=='?'){
            dp[n][m]=helper(s,p,n-1,m-1,dp);
        }else if(p.charAt(m-1)=='*'){
            boolean include=helper(s,p,n-1,m,dp);
            boolean exclude=helper(s,p,n,m-1,dp);

            dp[n][m]=include || exclude;
        }else{
            dp[n][m]=false;
        }
        return dp[n][m];
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        Boolean dp[][]=new Boolean[n+1][m+1];
        return helper(s,p,n,m,dp);
    }
}


// class Solution {
//     public boolean helper(String s,String p,int n,int m,Boolean dp[][]){
//         if(n==0 && m==0){
//             dp[n][m]= true;
//             return dp[n][m];
//         }
//         if(m==0){
//             dp[n][m]= false;
//             return dp[n][m];
//         }
//         if(n==0){
//             for(int j=0;j<m;j++){
//                 if(p.charAt(j)!='*'){
//                     dp[0][m]= false;
//                     return dp[0][m];
//                 }
//             }
//             dp[0][m]= true;
//             return dp[0][m];
//         }
//         if(dp[n][m]!=null){
//             return dp[n][m];
//         } 
//         if(s.charAt(n-1)==p.charAt(m-1) || p.charAt(m-1)=='?'){
//             dp[n][m]= helper(s,p,n-1,m-1,dp);
//         }
//         else if(p.charAt(m-1)=='*'){
//             boolean include=helper(s,p,n-1,m,dp);
//             boolean exclude=helper(s,p,n,m-1,dp);

//             dp[n][m]= include || exclude;
            
//         }
//         else{
//             dp[n][m]= false;
//         }
//         return dp[n][m];
//     }
//     public boolean tab(String s,String p,int n,int m){
//         boolean dp[][]=new boolean[n+1][m+1];
//         dp[0][0]=true;
//         for(int i=1;i<n+1;i++){
//             dp[i][0]=false;
//         }
//         for(int j=1;j<m+1;j++){
//             if(p.charAt(j-1)=='*'){
//                 dp[0][j]=dp[0][j-1];
//             }
//         }
//         for(int i=1;i<n+1;i++){
//             for(int j=1;j<m+1;j++){
//                 if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
//                     dp[i][j]=dp[i-1][j-1];
//                 }else if(p.charAt(j-1)=='*'){
//                     boolean include=dp[i-1][j];
//                     boolean exclude=dp[i][j-1];

//                     dp[i][j]=include || exclude;
//                 }else{
//                     dp[i][j]=false;
//                 }
//             }
//         }
//         return dp[n][m];
//     }
//     public boolean isMatch(String s, String p) {
//         int n=s.length();
//         int m=p.length();
//         // Boolean dp[][]=new Boolean[n+1][m+1];
//         // return helper(s,p,n,m,dp);
//         return tab(s,p,n,m);


//     }
// }