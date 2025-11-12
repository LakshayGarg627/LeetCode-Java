class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int total=rows*cols;
        int result[][]=new int[total][2];
        result[0][0]=rStart;
        result[0][1]=cStart;

        int count=1;
        int step=1;
        int r=rStart;
        int c=cStart;

        while(count<total){
            for(int i=0;i<step && count<total;i++){
                c++;
                if(r>=0 && r<rows && c>=0 && c<cols){
                    result[count][0]=r;
                    result[count][1]=c;
                    count++;
                }
            }
            for(int j=0;j<step && count<total;j++){
                r++;
                if(r>=0 && r<rows && c>=0 && c<cols){
                    result[count][0]=r;
                    result[count][1]=c;
                    count++;
                }
            }
            step++;
            for(int i=0;i<step && count<total;i++){
                c--;
                if(r>=0 && r<rows && c>=0 && c<cols){
                    result[count][0]=r;
                    result[count][1]=c;
                    count++;
                }
            }

            for(int j=0;j<step && count<total;j++){
                r--;
                if(r>=0 && r<rows && c>=0 && c<cols){
                    result[count][0]=r;
                    result[count][1]=c;
                    count++;
                }
            }
            step++;
        }
        return result;
    }
}