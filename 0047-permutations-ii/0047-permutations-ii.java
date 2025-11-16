class Solution {
    public void permutations(List<Integer> nums,int idx,int n,List<List<Integer>> result,HashSet<String> set){
        if(idx>=n){
            String key=nums.toString();
            if(!set.contains(key)){
                set.add(key);
                result.add(new ArrayList<>(nums));
            }
            return;
        }
        for(int i=idx;i<n;i++){
            swap(nums,idx,i);
            permutations(nums,idx+1,n,result,set);
            swap(nums,idx,i);
        }
    }
    public void swap(List<Integer> nums,int i,int j){
        int temp=nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j,temp);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int n=nums.length;
        List<Integer> temp=new ArrayList<>();
        for(int i=0;i<n;i++){
            temp.add(nums[i]);
        }
        HashSet<String> set=new HashSet<>();
        permutations(temp,0,n,result,set);
        return result;

    }
}