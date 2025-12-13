class Solution {
    public void helper(int arr[],List<Integer> nums,int n,int idx,List<List<Integer>> result){
        if(idx==n){
            result.add(new ArrayList<>(nums));
            return;
        }
        nums.add(arr[idx]);
        helper(arr,nums,n,idx+1,result);
        nums.remove(nums.size()-1);

        while(idx+1<n && arr[idx]==arr[idx+1]){
            idx++;
        }
        helper(arr,nums,n,idx+1,result);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        
        helper(nums,temp,n,0,result);
        return result;

    }
}


// class Solution {
//     public void helper(int arr[],List<Integer> nums,int n,int idx,List<List<Integer>> result,HashSet<String> set){
//         if(idx==n){
//             String key=nums.toString();
//             if(!set.contains(key)){
//                 set.add(key);
//                 result.add(new ArrayList<>(nums));
//             }
//             return;
//         }
//         nums.add(arr[idx]);
//         helper(arr,nums,n,idx+1,result,set);
//         nums.remove(nums.size()-1);
//         helper(arr,nums,n,idx+1,result,set);
//     }
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Arrays.sort(nums);
//         int n=nums.length;
//         List<List<Integer>> result=new ArrayList<>();
//         HashSet<String> set=new HashSet<>();
//         List<Integer> temp=new ArrayList<>();
        
//         helper(nums,temp,n,0,result,set);
//         return result;

//     }
// }