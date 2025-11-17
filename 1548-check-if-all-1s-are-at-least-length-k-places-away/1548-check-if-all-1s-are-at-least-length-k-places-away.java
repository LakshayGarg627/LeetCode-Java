class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                list.add(i);
            }
        }
        System.out.println(list);
        for(int i=0;i<list.size()-1;i++){
            if((list.get(i+1)-list.get(i)-1)<k){
                return false;
            }
        }
        return true;
    
    }
}