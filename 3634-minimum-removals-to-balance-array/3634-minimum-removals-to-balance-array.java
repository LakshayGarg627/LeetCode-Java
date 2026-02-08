class Solution {
    public int minRemoval(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        Arrays.sort(nums);
        int maxLen=-1;
        for(int right=0;right<n;right++){
            while((long)nums[right]>(long)nums[left]*k){
                left++;
            }
            maxLen=Math.max(maxLen,right-left+1);
        }
        return n-maxLen;
    }
}




// TLE + MLE
// class Solution {
//     public int helper(ArrayList<Integer> temp,int k,int start,int end,int dp[][]){
//         if(start>=temp.size() || end<0 || start>end){
//             return 0;
//         }
//         if(dp[start][end]!=-1){
//             return dp[start][end];
//         }
//         int max=temp.get(end);
//         int min=temp.get(start);
//         if(max<=(long)min*k){
//             return 0;
//         }
//         int way1=helper(temp,k,start,end-1,dp)+1;
//         int way2=helper(temp,k,start+1,end,dp)+1;

//         dp[start][end]= Math.min(way1,way2);
//         return dp[start][end];
//     }
//     public int minRemoval(int[] nums, int k) {
//         ArrayList<Integer> temp=new ArrayList<>();
//         int n=nums.length;
//         if(n==1){
//             return 0;
//         }
//         for(int i=0;i<n;i++){
//             temp.add(nums[i]);
//         }
//         Collections.sort(temp);
//         int dp[][]=new int[n][n];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i],-1);
//         }

//         return helper(temp,k,0,temp.size()-1,dp); 
//     }
// }

