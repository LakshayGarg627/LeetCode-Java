class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int result[]=new int[2];
        int n=grid.length;

        int temp[]=new int[(n*n)+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[grid[i][j]]++;
            }
        }
        for(int i=0;i<temp.length;i++){
            if(temp[i]==0){
                result[1]=i;
            }else if(temp[i]==2){
                result[0]=i;
            }
        }
        return result;
    }
}