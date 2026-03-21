class Solution {
    public int countCommas(int n) {
        if(n<1000){
            return 0;
        }
        int count=0;
        if(n>=1000 && n<999999){
            count=count+(n-1000+1);
        }
        return count;
    }
}