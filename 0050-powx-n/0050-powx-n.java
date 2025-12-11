class Solution {
    public double power(double x,int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        double halfpow=power(x,n/2);
        if(n%2==0){
            return halfpow*halfpow;
        }
        return halfpow*halfpow*x;

    }
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        return power(x,n);

    }
}