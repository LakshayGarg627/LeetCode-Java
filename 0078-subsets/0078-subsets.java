class Solution {
    public void helper(int nums[],int idx,List<List<Integer>> result,List<Integer> temp){
        if(idx==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        helper(nums,idx+1,result,temp);
        temp.remove(temp.size()-1);

        helper(nums,idx+1,result,temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        helper(nums,0,result,new ArrayList<>());
        return result;

    }
}

// class Solution {
//     public void helper(int nums[],List<List<Integer>> result,List<Integer> temp,int idx){
//         if(idx==nums.length){
//             result.add(new ArrayList<>(temp));
//             return;
//         }
//         temp.add(nums[idx]);
//         helper(nums,result,temp,idx+1);
//         temp.remove(temp.size()-1);

//         helper(nums,result,temp,idx+1);
//     }
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result=new ArrayList<>();
//         int n=nums.length;
//         List<Integer> temp=new ArrayList<>();
//         helper(nums,result,temp,0);
//         return result;
//     }
// }


// class Solution {
//     public void subsets(int nums[],List<Integer> temp,int i,List<List<Integer>> result){
//         if(i==nums.length){
//             result.add(new ArrayList<>(temp));
//             return;
//         }
//         temp.add(nums[i]);
//         subsets(nums,temp,i+1,result);
//         temp.remove(temp.size()-1);
//         subsets(nums,temp,i+1,result);
//     }
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result=new ArrayList<>();
//         subsets(nums,new ArrayList<>(),0,result);

//         return result;
        
//     }
// }