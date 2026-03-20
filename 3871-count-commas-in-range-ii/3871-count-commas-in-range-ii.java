class Solution {
    public int size(long n){
        int count=0;
        while(n>0){
            int rem=(int)n%10;
            count++;
            n=n/10;
        }
        return count;
    }
    public long countCommas(long n) {
        if(n<1000){
            return 0;
        }
        String str=Long.toString(n);
        long count=0;
        // int len=size(n);
        int len=str.length();
        if(len==4 || len==5 || len==6){
            count=count+(n-1000+1);
        }else if(len==7 || len==8 || len==9){
            count=count+(n-1000+1)+(n-1000000+1);
        }
        else if(len==10 || len==11 || len==12){
            count=count+(n-1000+1)+(n-1000000+1)+(n-1000000000+1);
        }else if(len==13 || len==14 || len==15){
            count=count+(n-1000+1)+(n-1000000+1)+(n-1000000000L+1)+(n-1000000000000L+1);
        }else{
            count=count+(n-1000+1)+(n-1000000+1)+(n-1000000000L+1)+(n-1000000000000L+1)+(n-1000000000000000L+1);
        }
        return count;
    }
}