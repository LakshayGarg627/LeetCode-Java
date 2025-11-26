class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int result[]=new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]){
                result[k++]=nums2[j++];
            }else{
                result[k++]=nums1[i++];
            }
        }
        while(i<nums1.length){
            result[k++]=nums1[i++];
        }
        while(j<nums2.length){
            result[k++]=nums2[j++];
        }
        int len=result.length;
        
        
        if(len%2==0){
            return (result[(len-1)/2]+result[len/2])/2.00;
        }
        return result[len/2];
    }
}