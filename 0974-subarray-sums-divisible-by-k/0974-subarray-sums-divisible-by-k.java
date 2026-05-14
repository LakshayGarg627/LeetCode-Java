class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int n=arr.length;
        
        long sum=0;
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(0L,1);

        int count=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            long rem=sum%k;
            if(rem<0){
                rem=rem+k;
            }
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
            
            
        }
        return count;
    }
}