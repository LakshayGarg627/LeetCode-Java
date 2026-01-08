class Solution {
    public int sum1(int n){
        int sum=0;
        while(n!=0){
            int rem=n%10;
            sum=sum+(rem*rem);
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        int a=n;
        while(true){
            int sq=sum1(n);
            n=sq;
            if(sq==1){
                return true;
            }
            if(set.contains(sq)){
                return false;
            }
            set.add(sq);
        }
        
    }
}