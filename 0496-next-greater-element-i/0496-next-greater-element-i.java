class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s=new Stack<>();
        int n=nums2.length;
        int nextgreater[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int curr=nums2[i];
            while(!s.isEmpty() && nums2[s.peek()]<=curr){
                s.pop();
            }
            if(s.isEmpty()){
                nextgreater[i]=-1;
            }else{
                nextgreater[i]=nums2[s.peek()];
            }
            s.push(i);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        int result[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i]=nextgreater[map.get(nums1[i])];
        }
        return result;
    }
}

// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         Stack<Integer> s=new Stack<>();
//         int n=nums2.length;
//         int nextGreater[]=new int[n];
//         for(int i=n-1;i>=0;i--){
//             int curr=nums2[i];
//             while(!s.isEmpty() && nums2[s.peek()]<=curr){
//                 s.pop();
//             }
//             if(s.isEmpty()){
//                 nextGreater[i]=-1;
//             }else{
//                 nextGreater[i]=nums2[s.peek()];
//             }
//             s.push(i);
//         }
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<nums2.length;i++){
//             map.put(nums2[i],i);
//         }
//         int result[]=new int[nums1.length];
//         for(int i=0;i<nums1.length;i++){
//             result[i]=nextGreater[map.get(nums1[i])];
//         }
//         return result;
//     }
// }