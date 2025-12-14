class Solution {
    public void helper(int arr[],List<Integer> temp,List<List<Integer>> result,int target,int idx,int curr){
        if(curr==0){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(idx==arr.length || curr<0){
            return;
        }
        if(arr[idx]<=curr){
            temp.add(arr[idx]);
            helper(arr,temp,result,target,idx,curr-arr[idx]);
            temp.remove(temp.size()-1);
            helper(arr,temp,result,target,idx+1,curr);
        }else{
            helper(arr,temp,result,target,idx+1,curr);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        int n=candidates.length;
        helper(candidates,new ArrayList<>(),result,target,0,target);
        return result;

    }
}