class Solution {
    public void helper(int k,int target,int start,List<List<Integer>> result,List<Integer> temp){
        if(k==0 && target==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(k==0 || target<0){
            return;
        }
        for(int digit=start;digit<=9;digit++){
            temp.add(digit);
            helper(k-1,target-digit,digit+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        helper(k,n,1,result,new ArrayList<>());
        return result;

    }
}