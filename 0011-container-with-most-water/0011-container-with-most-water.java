class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;

        int result=0;
        while(left<=right){
            int ht=Math.min(height[left],height[right]);
            int wt=right-left;

            int curr=ht*wt;
            result=Math.max(result,curr);

            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return result;
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
//             int width=right-left;
//             int currentArea=ht*width;
//             result=Math.max(result,currentArea);
//             if(height[left]<height[right]){
//                 left++;
//             }else{
//                 right--;
//             }
//         }
//         return result;

//     }
// }