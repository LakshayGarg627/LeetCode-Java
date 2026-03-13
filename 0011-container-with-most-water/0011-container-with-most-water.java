class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxWater=0;
        while(left<=right){
            int ht=Math.min(height[left],height[right]);
            int wt=right-left;
            int currArea=ht*wt;
            maxWater=Math.max(maxWater,currArea);

            if(height[right]>height[left]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxWater;
    }
}

// class Solution {
//     public int maxArea(int[] height) {
//         int n=height.length;
//         int left=0;
//         int right=n-1;

//         int result=0;
//         while(left<=right){
//             int ht=Math.min(height[left],height[right]);
//             int wt=right-left;

//             int curr=ht*wt;
//             result=Math.max(result,curr);

//             if(height[left]<height[right]){
//                 left++;
//             }else{
//                 right--;
//             }
//         }
//         return result;
//     }
// }
