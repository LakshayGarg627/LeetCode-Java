// More Optiomised
class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}


// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         int target=nums.length/2;
//         for(Integer key:map.keySet()){
//             if(map.get(key)==target){
//                 return key;
//             }
//         }
//         return -1;
//     }
// }