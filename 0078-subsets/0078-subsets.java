class Solution {
    public void subsets(int nums[],List<Integer> temp,int i,List<List<Integer>> result){
        if(i==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        subsets(nums,temp,i+1,result);
        temp.remove(temp.size()-1);
        subsets(nums,temp,i+1,result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        subsets(nums,new ArrayList<>(),0,result);

        return result;
        
    }
}