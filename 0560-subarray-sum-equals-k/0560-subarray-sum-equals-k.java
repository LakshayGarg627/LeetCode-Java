class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefix[]=new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        } 
        int count=0;
        for(int j=0;j<n;j++){
            if(prefix[j]==k){
                count++;
            }
            int value=prefix[j]-k;
            if(map.containsKey(value)){
                count+=map.get(value);
            }
            map.put(prefix[j],map.getOrDefault(prefix[j],0)+1);
        }
        return count;
    }
}

// Optimized code
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int n=nums.length;
//         HashMap<Integer,Integer> map=new HashMap<>();
//         int prefix[]=new int[n];
//         prefix[0]=nums[0];
//         for(int i=1;i<n;i++){
//             prefix[i]=prefix[i-1]+nums[i];
//         }
//         int count=0;
//         for(int j=0;j<n;j++){
//             if(prefix[j]==k){
//                 count++;
//             }
//             int value=prefix[j]-k;
//             if(map.containsKey(value)){
//                 count+=(map.get(value));
//             }
//             map.put(prefix[j],map.getOrDefault(prefix[j],0)+1);
//         }
//         return count;
//     }
// }

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int count=0;
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             int sum=0;
//             for(int j=i;j<n;j++){
//                 sum+=nums[j];
//                 if(sum==k){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }