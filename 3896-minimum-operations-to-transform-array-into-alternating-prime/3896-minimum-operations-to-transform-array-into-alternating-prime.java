class Solution {
    static final int MAX = 200000;
    static boolean[] isPrime = sieve(MAX);

    public static boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
    public int minOperations(int[] nums) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                if(!isPrime[nums[i]]){
                    while(!isPrime[nums[i]]){
                        nums[i]=nums[i]+1;
                        count++;
                    }
                }
            }else{
                if(isPrime[nums[i]]){
                    while(isPrime[nums[i]]){
                        nums[i]=nums[i]+1;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}