class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left[]=new int[n];
        int trappedWater=0;
        left[0]=height[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }
        int right[]=new int[n];
        right[n-1]=height[n-1];

        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }

        for(int i=0;i<n;i++){
            int waterLevel=Math.min(left[i],right[i]);
            trappedWater+=(waterLevel-height[i]);
        }
        return trappedWater;

    }
}


// Naive approach
// class Solution {
//     public int trap(int[] height) {
//        int n=height.length;
//        int trappedWater=0;
//        for(int i=0;i<n;i++){
//         int left=0;
//         int right=0;
//         for(int j=0;j<=i;j++){
//             left=Math.max(left,height[j]);
//         }
//         for(int j=i;j<n;j++){
//             right=Math.max(right,height[j]);
//         }
//         trappedWater+=(Math.min(left,right)-height[i]);
//        } 
//        return trappedWater;
//     }
// }

// Optimized approach-DP
// class Solution {
//     public int trap(int[] height) {
//         int n=height.length;
//         int left[]=new int[n];
//         left[0]=height[0];
//         for(int i=1;i<n;i++){
//             left[i]=Math.max(height[i],left[i-1]);
//         }
//         int right[]=new int[n];
//         right[n-1]=height[n-1];
//         for(int i=n-2;i>=0;i--){
//             right[i]=Math.max(height[i],right[i+1]);
//         }
//         int trappedWater=0;
//         for(int i=0;i<n;i++){
//             int waterlevel=Math.min(left[i],right[i]);
//             trappedWater+=(waterlevel-height[i]);
//         }
//         return trappedWater;

//     }
// }