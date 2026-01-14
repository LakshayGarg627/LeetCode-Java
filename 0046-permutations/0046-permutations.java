class Solution {
    public void helper(List<List<Integer>> result,List<Integer> temp,int idx,int n){
        if(idx==n){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<n;i++){
            swap(temp,idx,i);
            helper(result,temp,idx+1,n);
            swap(temp,idx,i);
        }
    }
    public void swap(List<Integer> temp,int a,int b){
        int tem=temp.get(a);
        temp.set(a,temp.get(b));
        temp.set(b,tem);
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);
        }
        int n=nums.length;
        helper(result,temp,0,n);
        return result;
    }
}


// class Solution {
//     public void perm(List<Integer> nums,int idx,List<List<Integer>> result,int n){
//         if(idx==n){
//             result.add(new ArrayList<>(nums));
//             return;
//         }
//         for(int i=idx;i<n;i++){
//             swap(nums,idx,i);
//             perm(nums,idx+1,result,n);
//             swap(nums,idx,i);
//         }
//     }
//     public void swap(List<Integer> nums,int idx,int i){
//         int temp=nums.get(idx);
//         nums.set(idx,nums.get(i));
//         nums.set(i,temp);
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> result=new ArrayList<>();
//         int n=nums.length;
//         List<Integer> temp=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             temp.add(nums[i]);
//         }
//         perm(temp,0,result,n);
//         return result;
        
//     }
// }