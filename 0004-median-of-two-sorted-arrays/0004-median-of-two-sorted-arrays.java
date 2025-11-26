class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int result[]=new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if(nums1[i]>=nums2[j]){
                result[k++]=nums2[j++];
            }else{
                result[k++]=nums1[i++];
            }
        }
        while(i<n){
            result[k++]=nums1[i++];
        }
        while(j<m){
            result[k++]=nums2[j++];
        }
        int len=result.length;
        if(len%2==0){
            return (result[(len-1)/2]+result[len/2])/2.00;
        }
        return result[len/2]/1.00;
    }
}