class Solution {
    public List<Integer> getRow(int rowIndex) {
        int dp[][]=new int[rowIndex+1][rowIndex+1];
        for(int i=0;i<=rowIndex;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                temp.add(dp[i][j]);
            }
            if(i==rowIndex){
                return temp;
            }
        }
        return new ArrayList<>();
    }
}