class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n=nums.length;
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        LinkedHashMap<Integer,List<Integer>> map2=new LinkedHashMap<>();
        for(Integer key:map.keySet()){
            int count=map.get(key);
            if(!map2.containsKey(count)){
                map2.put(count,new ArrayList<>());
            }
            map2.get(count).add(key);
        }
        for(Integer key:map2.keySet()){
            if(map2.get(key).size()==1){
                return map2.get(key).get(0);
            }
        }
        return -1;

    }
}